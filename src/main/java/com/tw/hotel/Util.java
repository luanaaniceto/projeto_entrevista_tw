package com.tw.hotel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Util {

	public static ArrayList<Date> converteStringDate(String[] dates) throws Exception {
		ArrayList<Date> dateConvert = new ArrayList<Date>();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy(EEE)", Locale.ENGLISH);

		for (String date : dates) {
			Date dt = formatter.parse(date.trim());
			dateConvert.add(dt);
		}

		return dateConvert;
	}

	// 0 - Dia de semana
	// 1 - Fim de semana
	public static HashMap<Integer, Integer> quantidadeDiasSemanaFimSemana(ArrayList<Date> periodoHospedagem) {
		HashMap<Integer, Integer> qtdDias = new HashMap<Integer, Integer>();
		qtdDias.put(0, 0);
		qtdDias.put(1, 0);

		for (Date date : periodoHospedagem) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dia = calendar.get(Calendar.DAY_OF_WEEK);

			if (dia != 1 && dia != 7) {
				int diaSemana = qtdDias.get(0);
				diaSemana = diaSemana + 1;
				qtdDias.put(0, diaSemana);
			} else {
				int fSemana = qtdDias.get(1);
				fSemana = fSemana + 1;
				qtdDias.put(1, fSemana);
			}
		}
		return qtdDias;
	}

	public static BigDecimal obterTarifaPorHotelPorPeriodo(Hotel hotel, Cliente cliente,
			ArrayList<Date> periodoHospedagem) {
		HashMap<Integer, Integer> qtdDias = Util.quantidadeDiasSemanaFimSemana(periodoHospedagem);

		Integer qtdDiaSemana = qtdDias.get(0);
		Integer qtdFimSemana = qtdDias.get(1);

		BigDecimal valorDiaSemanaPeriodo = BigDecimal.ZERO;
		BigDecimal valorFimSemanaPeriodo = BigDecimal.ZERO;

		HashMap<Cliente, BigDecimal> hashDiaSemana = hotel.getHashDiaSemana();
		HashMap<Cliente, BigDecimal> hashFimSemana = hotel.getHashFimSemana();

		valorDiaSemanaPeriodo = hashDiaSemana.get(cliente).multiply(new BigDecimal(qtdDiaSemana));
		valorFimSemanaPeriodo = hashFimSemana.get(cliente).multiply(new BigDecimal(qtdFimSemana));

		BigDecimal tarifa = valorDiaSemanaPeriodo.add(valorFimSemanaPeriodo);

		return tarifa;
	}

	private static String obterNomeHotelMelhorTarifa(List<Tarifario> tarifas) {
		String nomeHotel = "";

		Tarifario menorTarifa = null;

		for (Tarifario tarifa : tarifas) {

			if (menorTarifa == null || tarifa.getTarifa().compareTo(menorTarifa.getTarifa()) != 1) {
				menorTarifa = tarifa;

			} else if (tarifa.getTarifa().compareTo(menorTarifa.getTarifa()) == 0
					&& tarifa.getHotel().getClassificacao() > menorTarifa.getHotel().getClassificacao()) {
				menorTarifa = tarifa;
			}
		}

		nomeHotel = menorTarifa.getHotel().getNomeHotel();

		return nomeHotel;
	}

	public static String obterMelhorTarifaHoteisPorPeriodo(Cliente cliente, ArrayList<Date> periodoHospedagem) {
		ParqueFlores parque = new ParqueFlores();
		JardimBotanico jardim = new JardimBotanico();
		MarAtlantico mar = new MarAtlantico();

		Tarifario tarifaParqueFlores = new Tarifario(parque,
				obterTarifaPorHotelPorPeriodo(parque, cliente, periodoHospedagem));
		Tarifario tarifaJardimBotanico = new Tarifario(jardim,
				obterTarifaPorHotelPorPeriodo(jardim, cliente, periodoHospedagem));
		Tarifario tarifaMarAtlantico = new Tarifario(mar,
				obterTarifaPorHotelPorPeriodo(mar, cliente, periodoHospedagem));

		List<Tarifario> tarifas = Arrays.asList(tarifaParqueFlores, tarifaJardimBotanico, tarifaMarAtlantico);

		String hotel = obterNomeHotelMelhorTarifa(tarifas);

		return hotel;
	}

}
