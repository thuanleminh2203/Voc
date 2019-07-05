package thuanlm.com.Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	public BadRequestException() {
		// TODO Auto-generated constructor stub
	}

	public BadRequestException(String mss) {
		// TODO Auto-generated constructor stub
	}

}
