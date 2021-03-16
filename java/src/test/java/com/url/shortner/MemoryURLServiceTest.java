package com.url.shortner;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.HashMap;

public class MemoryURLServiceTest extends URLServiceTestBase{
    @Override
    protected URLService createTestSubject() {
        MemoryURLService memoryURLService = new MemoryURLService();
        memoryURLService.setUrls(new HashMap<Integer, String>());
        memoryURLService.setValidator(new UrlValidator());
        return memoryURLService;
    }
}