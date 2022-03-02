package io.mosip.websub.perf.utility.exception.handler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@ConditionalOnProperty(name = "websub.utilty.proxy-positive-response-enable",havingValue = "true")
public class RestExceptionHandler {


	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleEntityNotFound(Exception ex) {
		System.out.println("exceptional handler");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}