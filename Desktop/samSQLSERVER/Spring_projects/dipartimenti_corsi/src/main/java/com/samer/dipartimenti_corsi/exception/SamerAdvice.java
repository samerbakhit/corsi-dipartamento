package com.samer.dipartimenti_corsi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class SamerAdvice {
//	@ResponseBody
//	@ExceptionHandler(UserNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//public Map<String,String> exceptionHandler(UserNotFoundException exception){
//	Map<String,String> errorMap=new HashMap<>();
//	errorMap.put("errorMessage", exception.getMessage());
//	return errorMap;
//}
	@ResponseBody
	@ExceptionHandler(CorsoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> exceptionHandler(CorsoNotFoundException exception){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
//	@ResponseBody
//	@ExceptionHandler(CorsoAssociatoException.class)
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//	public Map<String,String> exceptionHandler(CorsoAssociatoException exception){
//		Map<String,String> errorMap=new HashMap<>();
//		errorMap.put("errorMessage", exception.getMessage());
//		return errorMap;
//	}
	
	@ResponseBody
	@ExceptionHandler(DipartimentoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
public Map<String,String> exceptionHandler(DipartimentoNotFoundException exception){
	Map<String,String> errorMap=new HashMap<>();
	errorMap.put("errorMessage", exception.getMessage());
	return errorMap;
}
	
}
