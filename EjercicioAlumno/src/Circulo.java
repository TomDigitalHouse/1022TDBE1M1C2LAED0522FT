public class Circulo extends Figura{
    public Circulo(Double numero) {
        super(numero);
    }

    @Override
    public void calcularArea() {
        if(this.getNumero() < 0){
            throw new ArithmeticException();
        }
        else {
            this.setArea(Math.PI* ( this.getNumero() * this.getNumero() ) );
        }
    }
}
