package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ar.edu.unlam.enums.TipoClasificacion;
import ar.edu.unlam.excepciones.ClienteExistenteException;
import ar.edu.unlam.excepciones.ClienteYaSuscriptoException;

public class GestorDePlanes {
	
	private TreeSet <Cliente> listadoDeClientes;
	private HashSet <Plan> listadoDePlanes;
	private HashSet <Canal> listadoDeCanales;
	private HashSet <Suscripcion> listadoDeSuscripcion;
	
	
	
	public GestorDePlanes() {
		this.listadoDeClientes = new TreeSet <> ();
		this.listadoDePlanes = new HashSet <> ();
		this.listadoDeCanales = new HashSet <> ();
		this.listadoDeSuscripcion = new HashSet <> ();
	}

	
	public Boolean agregarCliente(Cliente cliente) throws ClienteExistenteException{
		
		if(!this.listadoDeClientes.add(cliente)) {
			throw new ClienteExistenteException("El DNI ya se encuentra registrado");
	
		}
		return true;
	}


	public TreeSet<Cliente> obtenerListadoDeClientesOrdenadosPorDni() {
		return this.listadoDeClientes;
	}


	public Boolean agregarPlan(Plan plan) {
		return this.listadoDePlanes.add(plan);	
	}
	

	public ArrayList<PlanPremium> obtenerListadoDePlanesPremium() {
		 ArrayList<PlanPremium> planesPremium = new ArrayList <>();
		 
		 for (Plan planes : listadoDePlanes)  {
			if (planes instanceof PlanPremium) {
				planesPremium.add((PlanPremium) planes);
			}
		}
		 
		 return planesPremium;
	}


	public ArrayList<PlanBasico> obtenerListadoDePlanesBasico() {
       ArrayList<PlanBasico> planesBasicos = new ArrayList <>();
		 
		 for (Plan planes : listadoDePlanes)  {
			if (planes instanceof PlanBasico) {
				planesBasicos.add((PlanBasico) planes);
			}
		}
		 
		 return planesBasicos;
	}
	
	
	public Boolean agregarCanal(Canal canal) {
		return this.listadoDeCanales.add(canal);
	}
	
	
	public HashSet <Canal> obtenerListadoDeCanales(){
	return this.listadoDeCanales;
		
	}
		
	public HashSet<Canal>obtenerListadoPorPlan(Plan plan){
		
		HashSet<Canal>  canalesPorPlan = new HashSet<>();
	          for (Canal canal : listadoDeCanales) {
	        	  
	        	  if (plan instanceof PlanBasico) {
	        		  if (canal.getTipoClas() == TipoClasificacion.BASICO) {
	        			  canalesPorPlan.add(canal);
	        		  }
	        	  } else if (plan instanceof PlanPremium) {
	        		  canalesPorPlan.add(canal);
	        	  }
	         }
		
		return canalesPorPlan;
	}
	

	public Boolean agregarSuscripcion(Suscripcion suscripcion) throws ClienteYaSuscriptoException {
		
		Boolean buscado = buscarClienteSuscripto(suscripcion.getCliente().getDni());
	
		 HashSet<Canal> canalesAsociados = obtenerListadoPorPlan(suscripcion.getPlan());
		
		
		return this.listadoDeSuscripcion.add(suscripcion);
		
	
	}
		
	public Boolean buscarClienteSuscripto(Integer dni)throws ClienteYaSuscriptoException {
		
		for (Suscripcion sus : listadoDeSuscripcion) {
			if (sus.getCliente().getDni().equals(dni)) {
				throw new ClienteYaSuscriptoException("cliente ya suscripto");
			}	
		}
		
		return true;
	}
	
	
	public ArrayList <Suscripcion> obtenerListadoDeSuscripcionesBasicas(){
		
		 ArrayList <Suscripcion> listadoBasico = new ArrayList <>();
		 
		for (Suscripcion sus : listadoDeSuscripcion) {
			
			if (sus.getPlan() instanceof PlanBasico) {
				listadoBasico.add(sus);
			}		
		}
		
		return listadoBasico;
	}
	
	public ArrayList <Suscripcion> obtenerListadoDeSuscripcionesPremium(){
		
		 ArrayList <Suscripcion> listadoPremiun = new ArrayList <>();
		 
		for (Suscripcion sus : listadoDeSuscripcion) {
			
			if (sus.getPlan() instanceof PlanPremium) {
				listadoPremiun.add(sus);
			}		
		}
		
		return listadoPremiun;
	}
	
	public Double obtenerPrecioDeLasSuscripciones() {
		Double precio=0d;
		
		for (Suscripcion sus : listadoDeSuscripcion) {
			
			precio += sus.getPlan().obtenerPrecio();
		}
		return precio;
	}

	public Double obtenerTotalDeLasSuscripcionesBasicas() {
		Double precio=0d;
		
		for (Suscripcion sus : listadoDeSuscripcion) {
			
			if (sus.getPlan() instanceof PlanBasico) {
				precio += sus.getPlan().obtenerPrecio();
			}
		}
		return precio;
	}

	public Double obtenerTotalDeLasSuscripcionesPremium() {
		Double precio=0d;
		
		for (Suscripcion sus : listadoDeSuscripcion) {
			
			if (sus.getPlan() instanceof PlanPremium) {
				precio += sus.getPlan().obtenerPrecio();
			}
		}
		return precio;
	}


	public Map<Plan, Set<Cliente>> obtenerReporteDePlanes() {
	    Map<Plan, Set<Cliente>> reporte = new HashMap<>();
		
		for (Suscripcion sus : listadoDeSuscripcion) {
			Plan plan = sus.getPlan();
			Cliente cliente = sus.getCliente();
			 
			if(!reporte.containsKey(plan)) {
				TreeSet <Cliente> clienteDniDesc = new TreeSet <> (new DniOrdenadosDesc());
				clienteDniDesc.add(cliente);
				reporte.put(plan, clienteDniDesc);
				}
			else {
				reporte.get(plan).add(cliente);
			}
		
		}
	return reporte;
	}

	
}
	
	
	
	
	
	
	
	

