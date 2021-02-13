package crio.xmeme.exception;

public class MemeNotFoundException extends RuntimeException {

    public MemeNotFoundException() {
        super("The Meme you're trying to retrieve or update is not available");
    }
}
