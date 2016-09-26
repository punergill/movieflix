package egen.Restful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EntityAlreadyExist extends RuntimeException {

	private static final long serialVersionUID = 5603051271523964879L;

	public EntityAlreadyExist(String message) {
		super(message);
	}
}