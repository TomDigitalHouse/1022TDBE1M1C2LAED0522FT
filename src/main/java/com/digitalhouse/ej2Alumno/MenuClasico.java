package mesa_2;

public class MenuClasico extends Menu{

    public MenuClasico(Double precioBase) {
        super(precioBase);
    }

    @Override
    public Double calcularPrecio(){
        return this.getPrecioBase();
    }
}
