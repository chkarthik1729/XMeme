package crio.xmeme.exception;

public class MemeAlreadyExistsException extends RuntimeException {

    public MemeAlreadyExistsException() {
        super("A Meme with the content you're trying to post already exists");
    }
}
