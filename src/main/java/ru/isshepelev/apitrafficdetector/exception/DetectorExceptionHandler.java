package ru.isshepelev.apitrafficdetector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class DetectorExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElementException() {
        return new ResponseEntity<>("Список детекторов пуст", HttpStatus.OK);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException(){
        return  new ResponseEntity<>("Ошибка в параметрах запроса. Запрос не следует повторять",
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> IllegalArgumentException() {
        return new ResponseEntity<>(
                "Ошибка сервера при выполнении запроса. Запрос следует повторить позднее",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
