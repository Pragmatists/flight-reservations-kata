package pragmatists.training.flights;

@SuppressWarnings("serial")
public class InvalidRequestException extends Exception {

    public InvalidRequestException(String message) {
        super(message);
    }

}
