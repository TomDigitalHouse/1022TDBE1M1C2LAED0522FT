public class Circulo extends Figura{
    private Double radio;

    public Circulo(String nombre, Double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public Double calcularArea(){
        return (this.radio * 3.14) * (this.radio * 3.14);
    }

    public Double getRadio() {
        return radio;
    }
}
