package com.url.shortner;

public class FileURLService implements URLService{
    private String fileLocation;

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
    
    @Override
    public int storeURL(String url) {
        return 0;
    }

    @Override
    public String getURL(int id) {
        return null;
    }
}
