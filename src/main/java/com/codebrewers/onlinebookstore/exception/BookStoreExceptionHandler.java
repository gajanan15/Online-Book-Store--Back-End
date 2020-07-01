package com.codebrewers.onlinebookstore.exception;

import com.codebrewers.onlinebookstore.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookStoreExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AdminServiceException.class)
    public ResponseEntity<ResponseDTO> adminServiceExceptionHandler(AdminServiceException e) {
        ResponseDTO responseDto = new ResponseDTO(e.getMessage(), null);
        return new ResponseEntity<>(responseDto, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ResponseDTO> adminServiceExceptionHandler(UserServiceException e) {
        ResponseDTO responseDto = new ResponseDTO(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(JWTException.class)
    public ResponseEntity adminServiceExceptionHandler(JWTException e){
        ResponseDTO responseDTO = new ResponseDTO((e.getMessage()));
        return new ResponseEntity(responseDTO,HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(CouponException.class)
    public ResponseEntity adminServiceExceptionHandler(CouponException e){
        ResponseDTO responseDTO = new ResponseDTO((e.getMessage()));
        return new ResponseEntity(responseDTO,HttpStatus.ALREADY_REPORTED);
    }

}
