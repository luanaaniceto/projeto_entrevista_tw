package com.tw.hotel;

public enum Cliente {
	FIDELIDADE("Fidelidade"),
	REGULAR("Regular");
	
	private String tipoCliente;
	
	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	Cliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}
