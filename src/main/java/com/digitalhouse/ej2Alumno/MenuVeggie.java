package mesa_2;

import java.util.ArrayList;

public class MenuVeggie extends Menu{
    private ArrayList<String>salsas;

    public MenuVeggie(Double precioBase) {
        super(precioBase);
        this.salsas = new ArrayList<>();
    }
    public void agregarSalsa(String s){
      this.salsas.add(s);
    }
    @Override
    public Double calcularPrecio(){
        Double total = 0.0;
        Double recargo = this.getPrecioBase() * 1.10;
        Integer cantidadSalsas = this.salsas.size();
        total = recargo + (cantidadSalsas * 2);
        return total;
    }
}
