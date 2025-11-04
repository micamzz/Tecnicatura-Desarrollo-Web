package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import ar.edu.unlam.excepciones.ClienteExistenteEnEventoException;
import ar.edu.unlam.excepciones.EventoDuplicadoException;
import ar.edu.unlam.test.Taller;

public class EmpresaDeEvento {

	private HashSet <Cliente> listadoDeClientes;
	private HashSet <Evento> listadoDeEventos;
	
	public EmpresaDeEvento() {
		this.listadoDeClientes = new HashSet <>();
		this.listadoDeEventos = new HashSet <>();
	}
	
	
	
	public Boolean agregarCliente(Cliente cliente) {
		return this.listadoDeClientes.add(cliente);
	}
	
	
	public Boolean agregarClienteAUnEvento(Cliente cliente, Evento evento)throws ClienteExistenteEnEventoException {
		
	    Cliente clienteParticipante = buscarClientePorDNI(cliente.getDni());
	    if (clienteParticipante == null) return false;

	    if (evento.getListadoDeParticipantes().contains(clienteParticipante)) {
	        throw new ClienteExistenteEnEventoException("El cliente ya está registrado en el evento");
	    }
        
	    if (evento instanceof Taller) {
	        Taller taller = (Taller) evento;
	        if (taller.getCupoParticipantes() >= taller.getCUPO_MAXIMO()) {
	            return false; 
	        } else {
	            taller.incrementarCupo();
	        }
	    }
	    
	    if(evento instanceof Conferencia) {
	    	Conferencia confe = (Conferencia) evento;
	    	confe.incrementarCupo();
	    }
	    
	    
	    
	    return evento.getListadoDeParticipantes().add(clienteParticipante);
		}
	
	
	public Cliente buscarClientePorDNI(Integer dni) {	
		for (Cliente cliente : listadoDeClientes) {
			if (cliente.getDni().equals(dni))
				return cliente;	
		}
		return null;
	}
	
	
	public void agregarEvento(Evento evento) throws EventoDuplicadoException{
		 
		if (!this.listadoDeEventos.add(evento)) {
			throw new EventoDuplicadoException("Evento duplicado");
		}
	
	}

	public Evento buscarEventoPorCodigo(String codigoBuscado) {
		for (Evento eventos : listadoDeEventos) {
			if (eventos.getID().equalsIgnoreCase(codigoBuscado)){
				return eventos;
			}		
		}
		return null;
	}



	public Boolean verificarSiExisteElClienteEnUnEvento(Cliente cliente1) {
		
		for (Evento eventos : listadoDeEventos) {
			if ( eventos.getListadoDeParticipantes().contains(cliente1)){
				return true;
			}
			
		}
		return false;
	}
	
	
	public Double calcularPrecioFinal() {
		
		Double precio=0D;
		for (Evento eventos : listadoDeEventos) {
			precio += eventos.calcularPrecio();
		}
		
		return precio;
	}
	
	
	

	public ArrayList <Conferencia> obtenerListadoDeConferencias(){
		
		 ArrayList <Conferencia> nuevoListado = new  ArrayList<>();
		
		for (Evento eventos : listadoDeEventos) {
			if ( eventos instanceof Conferencia) {
				nuevoListado.add((Conferencia)eventos);
				
			}
		}
		
		return nuevoListado;
	}



	public HashMap<Conferencia, TreeSet<Cliente>> obtenerReporteDeConferencia() {
	    
	    HashMap<Conferencia, TreeSet<Cliente>> nuevoReporte = new HashMap<>();

	    ArrayList<Conferencia> nuevaConfe = obtenerListadoDeConferencias();

	    for (Conferencia conferencia : nuevaConfe) {
	       
	        TreeSet<Cliente> clientes = new TreeSet<>(new ParticipantesOrdenadosPorApellido());
	        
	      
	        clientes.addAll(conferencia.getListadoDeParticipantes());
	        

	        nuevoReporte.put(conferencia, clientes);
	    }

	    return nuevoReporte;
	}
	
	
	
	
}
