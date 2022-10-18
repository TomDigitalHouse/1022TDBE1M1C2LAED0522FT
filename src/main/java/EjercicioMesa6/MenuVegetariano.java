package EjercicioMesa6;

public class MenuVegetariano extends Menu {
    private final int cantidadSalsas;
    private final Double precioFinal;

    public MenuVegetariano(Double precioBase, int cantidadSalsas) {
        super(precioBase);
        this.cantidadSalsas = cantidadSalsas;
        this.precioFinal = precioBase+(precioBase/100)+(2*cantidadSalsas);
    }
}
