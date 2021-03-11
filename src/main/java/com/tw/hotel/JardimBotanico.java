package com.tw.hotel;

import java.math.BigDecimal;
import java.util.HashMap;

public class JardimBotanico extends Hotel{
	
	public JardimBotanico() {
		preencherDiariaDiaSemana();
		preencherDiariaFimSemana();
	}
	
	public String nomeHotel = "Jardim Botânico";
	
	public int classificacao = 4;
	
	private HashMap<Cliente, BigDecimal> valoresDiaSemanaCliente;
	private HashMap<Cliente, BigDecimal> valoresFimSemanaCliente;	


	public void setValoresDiaSemanaCliente(HashMap<Cliente, BigDecimal> hashDiaSemana) {
		this.valoresDiaSemanaCliente = hashDiaSemana;
	}


	public HashMap<Cliente, BigDecimal> getValoresDiaSemanaCliente() {
		return valoresDiaSemanaCliente;
	}


	public HashMap<Cliente, BigDecimal> getValoresFimSemanaCliente() {
		return valoresFimSemanaCliente;
	}


	public void setValoresFimSemanaCliente(HashMap<Cliente, BigDecimal> hashFimSemana) {
		this.valoresFimSemanaCliente = hashFimSemana;
	}
	
	
	
	public String getNomeHotel() {
		return this.nomeHotel;
	}
	
	public int getClassificacao() {
		return this.classificacao;
	}
	
	private void preencherDiariaDiaSemana() {
		HashMap<Cliente, BigDecimal> hashDiaSemana = new HashMap<Cliente, BigDecimal>();
		hashDiaSemana.put(Cliente.REGULAR, new BigDecimal(160));
		hashDiaSemana.put(Cliente.FIDELIDADE, new BigDecimal(110));
		
		this.setValoresDiaSemanaCliente(hashDiaSemana);
	}
	
	private void preencherDiariaFimSemana() {
		HashMap<Cliente, BigDecimal> hashFimSemana = new HashMap<Cliente, BigDecimal>();
		hashFimSemana.put(Cliente.REGULAR, new BigDecimal(60));
		hashFimSemana.put(Cliente.FIDELIDADE, new BigDecimal(50));
		
		this.setValoresFimSemanaCliente(hashFimSemana);
	}
}
