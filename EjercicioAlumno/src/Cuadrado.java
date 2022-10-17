public class Cuadrado extends Figura{
    public Cuadrado(Double numero) {
        super(numero);
    }

    @Override
    public void calcularArea() {
        if(this.getNumero() < 0){
            throw new ArithmeticException();
        }
        else {
            this.setArea(this.getNumero() * this.getNumero());
        }
    }
}
