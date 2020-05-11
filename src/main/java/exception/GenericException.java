package exception;

/**
 * @author pramesh-bhattarai
 */
public final class GenericException extends RuntimeException {

    public GenericException(String message) {
        super(message);
    }

    public GenericException(Exception e) {
        super(e);
    }
}

