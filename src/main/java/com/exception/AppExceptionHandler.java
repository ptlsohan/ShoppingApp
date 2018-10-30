package com.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value= {RuntimeException.class})
	public void handler(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
		e.printStackTrace();
		request.setAttribute("errorMessage", e.getMessage());
		request.getRequestDispatcher("error").forward(request, response);
	}
}
