package com.url.shortner;

public class FileURLServiceTest extends URLServiceTestBase{
    @Override
    protected URLService createTestSubject() {
        FileURLService fileURLService = new FileURLService();
        return fileURLService;
    }
}
