public class Rectangulo extends Figura{
    private Double largo;
    private Double ancho;

    public Rectangulo(String nombre, Double largo, Double ancho) {
        super(nombre);
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public Double calcularArea() {
        return this.largo * this.ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public Double getAncho() {
        return ancho;
    }
}
