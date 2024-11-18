package handsOn_hadiyasa.handson_spring_webmvc.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body("Method argument is invalid: " + ex.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex){
        return ResponseEntity.badRequest().body("Media type is not supported (Mohon koreksi): " + ex.getMessage());
    }

   /* @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body("Validation Error: " + ex.getMessage());
    }*/
}
