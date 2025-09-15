package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Tarifa {
	
public static Integer cantidadDeTarifas =0;
	private Integer id;
	private LocalDate desde;
	private LocalDate hasta;
	private Double valor;

	public Tarifa(LocalDate desde, Double valor) {
		this.id = ++cantidadDeTarifas;
		this.desde = desde;
		this.hasta = null;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDesde() {
		return desde;
	}

	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}

	public LocalDate getHasta() {
		return this.hasta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setHasta(LocalDate minusDays) {
		this.hasta = minusDays;	
	}

	

}
