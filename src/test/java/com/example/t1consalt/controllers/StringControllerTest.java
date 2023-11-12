package com.example.t1consalt.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest
@AutoConfigureMockMvc
class StringControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void count() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/count?str=aaaaabcccc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("\"a\": 5, \"c\": 4, \"b\": 1"));
    }

    @Test
    void handleNullableStringEx() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/count"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Ошибка валидации: Параметр str не найден"));
    }

    @Test
    void handleEmptyStringEx() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/count?str="))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Ошибка валидации: Параметр str не должен быть пустым"));
    }
}