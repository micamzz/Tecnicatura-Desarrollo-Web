package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Suscripcion {
	
	private static Integer proximoId=0;
	private Integer id;
	private Cliente cliente;
	private Plan plan;
	private HashSet <Canal> listadoDeCanales;
	
	
	
	public Suscripcion(Cliente cliente, Plan plan, HashSet<Canal> listadoPlanes) {
		super();
		this.cliente = cliente;
		this.plan = plan;
		this.listadoDeCanales = listadoPlanes;
		this.id = ++proximoId;
	}



	public Integer getId() {
		return id;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public Plan getPlan() {
		return plan;
	}



	public HashSet<Canal> getListadoDeCanales() {
		return listadoDeCanales;
	}
	
	
	

	

}
