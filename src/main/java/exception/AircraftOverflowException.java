package exception;

public class AircraftOverflowException  extends Exception{
    public AircraftOverflowException() {
    }

    public AircraftOverflowException(String message) {
        super(message);
    }

    public AircraftOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public AircraftOverflowException(Throwable cause) {
        super(cause);
    }

    public AircraftOverflowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
