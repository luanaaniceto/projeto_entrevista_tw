package com.tw.hotel;

import java.math.BigDecimal;
import java.util.HashMap;

public class MarAtlantico extends Hotel{
	
	public MarAtlantico() {
		preencherDiariaDiaSemana();
		preencherDiariaFimSemana();
	}
	
	public String nomeHotel = "Mar do Atlântico";
	
	public int classificacao = 5;
	
	private HashMap<Cliente, BigDecimal> hashDiaSemana;
	private HashMap<Cliente, BigDecimal> hashFimSemana;	


	public HashMap<Cliente, BigDecimal> getHashDiaSemana() {
		return hashDiaSemana;
	}


	public void setHashDiaSemana(HashMap<Cliente, BigDecimal> hashDiaSemana) {
		this.hashDiaSemana = hashDiaSemana;
	}


	public HashMap<Cliente, BigDecimal> getHashFimSemana() {
		return hashFimSemana;
	}


	public void setHashFimSemana(HashMap<Cliente, BigDecimal> hashFimSemana) {
		this.hashFimSemana = hashFimSemana;
	}
	
	
	public String getNomeHotel() {
		return this.nomeHotel;
	}
	
	public int getClassificacao() {
		return this.classificacao;
	}
	
	private void preencherDiariaDiaSemana() {
		HashMap<Cliente, BigDecimal> hashDiaSemana = new HashMap<Cliente, BigDecimal>();
		hashDiaSemana.put(Cliente.REGULAR, new BigDecimal(220));
		hashDiaSemana.put(Cliente.FIDELIDADE, new BigDecimal(100));
		
		this.setHashDiaSemana(hashDiaSemana);
	}
	
	private void preencherDiariaFimSemana() {
		HashMap<Cliente, BigDecimal> hashFimSemana = new HashMap<Cliente, BigDecimal>();
		hashFimSemana.put(Cliente.REGULAR, new BigDecimal(150));
		hashFimSemana.put(Cliente.FIDELIDADE, new BigDecimal(40));
		
		this.setHashFimSemana(hashFimSemana);
	}

}
