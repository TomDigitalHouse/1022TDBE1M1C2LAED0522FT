package exceptions;

public class PaisNotFoundException extends PeliculaException{
    public PaisNotFoundException(String errmsg) {
        super(errmsg);
    }
}
