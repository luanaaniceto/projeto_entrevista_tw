package com.tw.hotel;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class Hotel {

	private int classificacao;

	private String nomeHotel;

	private HashMap<Cliente, BigDecimal> hashDiaSemana;

	private HashMap<Cliente, BigDecimal> hashFimSemana;

	public int getClassificacao() {
		return this.classificacao;
	}

	public String getNomeHotel() {
		return this.nomeHotel;
	}

	public HashMap<Cliente, BigDecimal> getHashDiaSemana() {
		return this.hashDiaSemana;
	}

	public HashMap<Cliente, BigDecimal> getHashFimSemana() {
		return this.hashFimSemana;
	}
}
