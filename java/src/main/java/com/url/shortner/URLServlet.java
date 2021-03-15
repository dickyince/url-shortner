package com.url.shortner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLServlet extends HttpServlet {
    private URLService urlService;

    public void setUrlService(URLService urlService) {
        this.urlService = urlService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getRequestURI();
        if(id == null || "".equals(id)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
        else if(id.matches("^\\d+$")){
            String url = urlService.getURL(Integer.valueOf(id));
            response.sendRedirect(url);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        int id = urlService.storeURL(url);
        if(id == 0) {
            request.setAttribute("error", "Cannot store url as it is not valid.");
        }
        else {
            request.setAttribute("id", id);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
