package com.example.t1consalt.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class StringServiceTest {

    @Autowired
    StringService stringService;

    @Test
    void countChars() {
        String expected = "\"a\": 5, \"c\": 4, \"b\": 1";
        Assert.assertEquals(expected, stringService.countChars("aaaaabcccc"));
    }

}