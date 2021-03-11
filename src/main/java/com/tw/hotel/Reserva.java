package com.tw.hotel;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {

	
	public static String obterHotelMelhorReserva(String entrada) throws Exception {
		String hotelMelhorReserva = "";
		String[] tipoClienteDatas = entrada.split(":");
		String[] datas = tipoClienteDatas[1].split(",");
		Cliente cliente = null;
		
		
		for (Cliente c : Cliente.values()) {
            if (c.getTipoCliente().equals(tipoClienteDatas[0])) {
            	cliente = c;
            }
        }
		
		ArrayList<Date> periodoHospedagem = Util.converteStringDate(datas);
		hotelMelhorReserva = Util.obterMelhorTarifaHoteisPorPeriodo(cliente, periodoHospedagem);
		
		return hotelMelhorReserva;
	}
}
