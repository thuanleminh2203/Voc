package thuanlm.com.Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String mesString) {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
