package proxy;

public class ForbiddenException extends Exception{
    public ForbiddenException() {
        super("Censored!");
    }
}
