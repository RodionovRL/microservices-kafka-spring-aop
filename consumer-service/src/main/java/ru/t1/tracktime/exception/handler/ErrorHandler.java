package ru.t1.tracktime.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.t1.tracktime.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    public static final String INCORRECTLY_MADE_REQUEST = "Incorrectly made request";

    record Error(List<String> errors, String message, String reason, HttpStatus httpStatus, LocalDateTime timeStamp) {
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error errorMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        log.error("EH: MethodArgumentNotValidException: {}", ex.getMessage(), ex);
        return new Error(
                new ArrayList<>(),
                ex.getMessage(),
                INCORRECTLY_MADE_REQUEST,
                HttpStatus.BAD_REQUEST,
                now());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error errorMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex) {
        log.error("EH: MethodArgumentTypeMismatchException: {}", ex.getMessage(), ex);
        return new Error(
                new ArrayList<>(),
                String.format("%s. Param:%s Value=%s", ex.getMessage(), ex.getName(), ex.getValue()),
                INCORRECTLY_MADE_REQUEST,
                HttpStatus.BAD_REQUEST,
                now());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error errorMissingServletRequestParameterException(final MissingServletRequestParameterException ex) {
        log.error("EH: MissingServletRequestParameterException: {}", ex.getMessage(), ex);
        return new Error(
                new ArrayList<>(),
                ex.getMessage(),
                INCORRECTLY_MADE_REQUEST,
                HttpStatus.BAD_REQUEST,
                now());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error errorDataIntegrityViolationException(final DataIntegrityViolationException ex) {
        log.error("EH: DataIntegrityViolationException: {}", ex.getMessage(), ex);
        return new Error(
                new ArrayList<>(),
                Objects.requireNonNull(ex.getRootCause()).getMessage(),
                "Integrity constraint has been violated.",
                HttpStatus.CONFLICT,
                now());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error errorConstraintViolationException(final ConstraintViolationException ex) {
        log.error("EH: ConstraintViolationException: {}", ex.getMessage(), ex);
        return new Error(
                new ArrayList<>(),
                ex.getMessage(),
                "Integrity constraint has been violated.",
                HttpStatus.CONFLICT,
                now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNotFoundException(final NotFoundException ex) {
        log.error("EH: NotFoundException: {}", ex.getMessage(), ex);
        return new Error(
                new ArrayList<>(),
                ex.getMessage(),
                "The required object was not found.",
                HttpStatus.NOT_FOUND,
                now());
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error handleHttpMessageConversionException(final HttpMessageConversionException ex) {
        log.error("EH: HttpMessageConversionException: {}", ex.getMessage());
        return new Error(
                new ArrayList<>(),
                ex.getMessage(),
                "Request parameters validation error.",
                HttpStatus.CONFLICT,
                now());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error errorThrowableException(final Throwable ex) {
        log.error("EH: Internal Server Error. {}", ex.getMessage(), ex);
        return new Error(
                Arrays.stream(ex.getStackTrace())
                        .map(StackTraceElement::toString)
                        .toList(),
                ex.getMessage(),
                "Internal Server Error.",
                HttpStatus.I_AM_A_TEAPOT,
                now());
    }
}

