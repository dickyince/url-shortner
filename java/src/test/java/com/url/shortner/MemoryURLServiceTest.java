package com.url.shortner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemoryURLServiceTest {

    // class under test
    private MemoryURLService testSubject;

    @Before
    public void setUp() {
        testSubject = new MemoryURLService();
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
}
