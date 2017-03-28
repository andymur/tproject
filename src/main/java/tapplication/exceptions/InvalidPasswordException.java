package tapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alexpench on 23.03.17.
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Invalid password")
public class InvalidPasswordException extends RuntimeException {
}
