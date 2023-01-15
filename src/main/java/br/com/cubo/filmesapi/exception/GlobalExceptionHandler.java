package br.com.cubo.filmesapi.exception;

import br.com.cubo.filmesapi.domain.dto.ErrorDetailsDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetailsDto handleResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest) {
		ErrorDetailsDto errorDetails = new ErrorDetailsDto(LocalDateTime.now(), exception.getMessage(),
				webRequest.getDescription(false));
		return errorDetails;
	}

    @ExceptionHandler(MovieExistsException.class)
    public ResponseEntity<ErrorDetailsDto> handleMovieExistsException(MovieExistsException exception,
                                                                     WebRequest webRequest) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(LocalDateTime.now(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetailsDto handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorDetailsDto errorDetailsDto = new ErrorDetailsDto(
                LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false));
        return errorDetailsDto;
    }
}
