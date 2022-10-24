package exceptions;

public class PaisDenegadoException extends PeliculaException {
    public PaisDenegadoException() {
        super("model.Pais no admitido");
    }
}
