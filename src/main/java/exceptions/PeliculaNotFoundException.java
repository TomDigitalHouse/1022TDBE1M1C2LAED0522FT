package exceptions;

public class PeliculaNotFoundException extends PeliculaException{
    public PeliculaNotFoundException(String errmsg) {
        super(errmsg);
    }
}
