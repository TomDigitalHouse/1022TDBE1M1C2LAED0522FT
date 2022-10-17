public abstract class Figura {
    private Double area;
    private Double numero; //Radio o Lado;

    public Figura(Double numero) {
        this.numero = numero;
    }

    public void setArea(Double n){
        this.area = n;
    }

    public Double getArea() {
        return area;
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public abstract void calcularArea();
}
