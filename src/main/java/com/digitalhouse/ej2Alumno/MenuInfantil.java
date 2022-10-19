package mesa_2;

import java.util.ArrayList;

public class MenuInfantil extends Menu{
    private ArrayList<String> juguetes;

    public MenuInfantil(Double precioBase) {
        super(precioBase);
        this.juguetes = new ArrayList<>();
    }
    public void agregarJuguete(String j){
        this.juguetes.add(j);
    }

    @Override
    public Double calcularPrecio() {
        Double total = 0.0;
        Integer cantidadJuguetes = this.juguetes.size();

        total = this.getPrecioBase() + (cantidadJuguetes * 3);
        return total;
    }

}
