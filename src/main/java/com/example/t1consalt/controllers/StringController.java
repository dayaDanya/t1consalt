package com.example.t1consalt.controllers;

import com.example.t1consalt.services.StringService;
import com.example.t1consalt.util.EmptyStringException;
import com.example.t1consalt.util.NullableStringException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Validated
@org.springframework.web.bind.annotation.RestController
public class StringController {

    @Autowired
    private StringService stringService;

    @GetMapping("/count")
    public String count(@RequestParam(required = false)  String str) {
        if (str == null)
            throw new NullableStringException("Параметр str не найден");
        else if (str.isEmpty())
            throw new EmptyStringException("Параметр str не должен быть пустым");
        return stringService.countChars(str);
    }

    @ExceptionHandler(NullableStringException.class)
    public ResponseEntity<String> handleNullableStringEx(NullableStringException ex) {

        return new ResponseEntity<>("Ошибка валидации: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyStringException.class)
    public ResponseEntity<String> handleEmptyStringEx(EmptyStringException ex) {

        return new ResponseEntity<>("Ошибка валидации: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
