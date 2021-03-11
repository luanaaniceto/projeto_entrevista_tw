package com.tw.hotel.test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.tw.hotel.Reserva;
import com.tw.hotel.Util;

public class ReservaTest {
	@Test
	public void testarReservaParqueFlores() throws Exception {
		String hotel = "";
		String entrada = "Regular: 16Mar2020(mon), 17Mar2020(tue), 18Mar2020(wed)";
		hotel = Reserva.obterHotelMelhorReserva(entrada);
		assertEquals(hotel, "Parque das Flores");
	}
	
	@Test
	public void testarReservaJardimBotanico() throws Exception {
		String hotel = "";
		String entrada = "Regular: 20Mar2020(fri), 21Mar2020(sat), 22Mar2020(sun)";
		hotel = Reserva.obterHotelMelhorReserva(entrada);
		assertEquals(hotel, "Jardim Botânico");
	}
	
	@Test
	public void testarReservaMarAtlantico() throws Exception {
		String hotel = "";
		String entrada = "Fidelidade: 26Mar2020(thu), 27Mar2020(fri), 28Mar2020(sat)";
		hotel = Reserva.obterHotelMelhorReserva(entrada);
		assertEquals(hotel, "Mar do Atlântico");
	}
	
	@Test
	public void retornaQuantidadeDiasSemana() throws Exception {
		String[] datas = {"07Mar2021(sun)", "08Mar2021(mon)", "09Mar2021(tue)", "10Mar2021(wed)"};
		ArrayList<Date> datasConvertidas = Util.converteStringDate(datas);
		int qtdDiaSemana = Util.quantidadeDiasSemanaFimSemana(datasConvertidas).get(0);
		assertEquals(qtdDiaSemana, 3);
	}
	
	@Test
	public void retornaQuantidadeFimSemana() throws Exception {
		String[] datas = {"06Mar2021(sat)", "07Mar2021(sun)", "08Mar2021(mon)", "09Mar2021(tue)"};
		ArrayList<Date> datasConvertidas = Util.converteStringDate(datas);
		int qtdFimSemana = Util.quantidadeDiasSemanaFimSemana(datasConvertidas).get(1);
		assertEquals(qtdFimSemana, 2);
	}
}
