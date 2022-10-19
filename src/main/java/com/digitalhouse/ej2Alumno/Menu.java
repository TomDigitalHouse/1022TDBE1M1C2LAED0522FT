package mesa_2;

import lombok.Getter;

@Getter
public abstract class Menu {
    private Double precioBase;

    public Menu(Double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract Double calcularPrecio();

    public Double getPrecioBase() {
        return precioBase;
    }
}
