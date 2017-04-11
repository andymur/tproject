package tapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alexpench on 23.03.17.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Quantity is less then requested")
public class PlaceToOrderException extends RuntimeException {
}
