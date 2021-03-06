package com.url.shortner;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.Map;

public class MemoryURLService implements URLService{
    private Map<Integer, String> urls;
    private UrlValidator validator;

    public void setUrls(Map<Integer, String> urls) {
        this.urls = urls;
    }

    public void setValidator(UrlValidator validator) {
        this.validator = validator;
    }

    @Override
    public int storeURL(String url) {
        if(validator.isValid(url)) {
            int id = getId();
            urls.put(id, url);
            return id;
        }
        return 0;
    }

    @Override
    public String getURL(int id) {
        return urls.get(id);
    }

    private int getId() {
        return urls.size() + 1;
    }
}
