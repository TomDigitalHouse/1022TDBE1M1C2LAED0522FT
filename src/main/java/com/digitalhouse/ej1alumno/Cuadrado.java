public class Cuadrado extends Figura{
    private Double lado;

    public Cuadrado(String nombre, Double lado) {
        super(nombre);
        this.lado = lado;
    }

    @Override
    public Double calcularArea(){
        return this.lado * 2;
    }

    public Double getLado() {
        return lado;
    }
}
