package com.tw.hotel;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class Hotel {

	private int classificacao;

	private String nomeHotel;

	private HashMap<Cliente, BigDecimal> valoresDiaSemanaCliente;

	private HashMap<Cliente, BigDecimal> valoresFimSemanaCliente;

	public int getClassificacao() {
		return this.classificacao;
	}

	public String getNomeHotel() {
		return this.nomeHotel;
	}

	public HashMap<Cliente, BigDecimal> getValoresDiaSemanaCliente() {
		return this.valoresDiaSemanaCliente;
	}

	public HashMap<Cliente, BigDecimal> getValoresFimSemanaCliente() {
		return this.valoresFimSemanaCliente;
	}
}
