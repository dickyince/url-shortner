package com.url.shortner;

import org.apache.commons.validator.routines.UrlValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MemoryURLServiceTest {

    // class under test
    private MemoryURLService testSubject;

    // test data
    private String testUrl = "http://www.test.com";

    @Before
    public void setUp() {
        testSubject = new MemoryURLService();
        testSubject.setUrls(new HashMap<Integer, String>());
        testSubject.setValidator(new UrlValidator());
    }

    @Test
    public void testStoreURL_failure_if_url_is_null() {
        // if
        int expectedResult = 0;
        // when
        int actualResult = testSubject.storeURL(null);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testStoreURL_failure_if_url_not_valid() {
        // if
        String url = "http://www.test";
        int expectedResult = 0;
        // when
        int actualResult = testSubject.storeURL(url);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testStoreURL_success_if_url_valid() {
        // if
        int expectedResult = 1;
        // when
        int actualResult = testSubject.storeURL(testUrl);
        // then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetURL_null_if_id_equals_0() {
        // if
        int id = 0;
        // when
        String actualResult = testSubject.getURL(id);
        // then
        assertEquals(null, actualResult);
    }

    @Test
    public void testGetURL_null_if_id_not_registered() {
        // if
        testSubject.storeURL(testUrl);
        int id = 45;
        // when
        String actualResult = testSubject.getURL(id);
        // then
        assertEquals(null, actualResult);
    }

    @Test
    public void testGetURL_success_if_id_registered() {
        // if
        int id = testSubject.storeURL(testUrl);
        // when
        String actualResult = testSubject.getURL(id);
        // then
        assertEquals(testUrl, actualResult);
    }
}
