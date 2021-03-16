package com.url.shortner;

public interface URLService {
    public int storeURL(String url);

    public String getURL(int id);
}