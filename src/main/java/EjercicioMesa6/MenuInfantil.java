package EjercicioMesa6;


public class MenuInfantil extends Menu {
    private final int cantidadJuguetes;
    private final Double precioFinal;

    public MenuInfantil(Double precioBase, int cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
        this.precioFinal = precioBase+(3*this.cantidadJuguetes);
    }
}
