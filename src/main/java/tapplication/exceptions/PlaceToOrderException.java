package tapplication.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by alexpench on 23.03.17.
 */
public class PlaceToOrderException extends RuntimeException {
    HttpStatus status;
    public PlaceToOrderException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
