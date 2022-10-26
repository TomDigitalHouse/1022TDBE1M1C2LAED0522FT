package com.digitalhouse.mesas;

import com.digitalhouse.mesas.apis.AvionAPI;
import com.digitalhouse.mesas.apis.HotelAPI;
import com.digitalhouse.mesas.facade.CheckFacade;

public class App {

	public static void main(String[] args) {
		var avionAPI = new AvionAPI();
		var hotelAPI = new HotelAPI();
		var cliente1 = new CheckFacade(avionAPI, hotelAPI);
		cliente1.buscar("02/07/2018", "08/07/2018", "Lima", "Cancún");
		var cliente2 = new CheckFacade(avionAPI, hotelAPI);
		cliente2.buscar("02/07/2018", "08/07/2018", "Lima", "Quito");
	}

}
