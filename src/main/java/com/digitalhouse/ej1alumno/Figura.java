public abstract class Figura {
    private String nombre;


    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract Double calcularArea();
}
