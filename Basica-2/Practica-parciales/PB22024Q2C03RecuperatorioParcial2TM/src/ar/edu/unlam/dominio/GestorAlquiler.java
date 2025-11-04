package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import ar.edu.unlam.excepciones.DniDuplicadoException;
import ar.edu.unlam.excepciones.NoDisponibleException;
import ar.edu.unlam.menum.TipoBicicleta;

public class GestorAlquiler {

	private HashSet <Cliente> listadoDeClientes;
	private HashSet <Vehiculo> listadoDeVehiculos;
	private ArrayList <Alquiler> listadoDeAlquileres;
	
	public GestorAlquiler() {
		this.listadoDeClientes = new HashSet <>();
		this.listadoDeVehiculos =  new HashSet <>();
		this.listadoDeAlquileres = new ArrayList <> ();
	}

	public Boolean agregarCliente(Cliente cliente1) throws DniDuplicadoException {
		
	if (! this.listadoDeClientes.add(cliente1)) {
		throw new DniDuplicadoException("NO se puede agregar al cliente- DNI duplicado");
		}

	return true;
	}

	
	public Boolean agregarVehiculo(Vehiculo nuevo) {
		return this.listadoDeVehiculos.add(nuevo);
	}
	
	
	
	public HashSet <Bicicleta> obtenerListadoDeBicicletasDePaseo(){
		HashSet <Bicicleta> listadoDeBicisDePaseo = new HashSet <> ();
		
		for (Vehiculo vehiculo : listadoDeVehiculos) {
			
			if (vehiculo instanceof Bicicleta && ((Bicicleta) vehiculo).getTipoBici() == TipoBicicleta.PASEO) {
					listadoDeBicisDePaseo.add((Bicicleta) vehiculo);
				}
			}	
		return listadoDeBicisDePaseo;
		}		

	
	
	public TreeSet <Moto> obtenerMotosOrdenadasPorPatente(){
		
		TreeSet <Moto> motosOrdenadas = new TreeSet <> (new MotosOrdenadasPorPatente());
		
		for (Vehiculo vehiculo : listadoDeVehiculos) {
			if (vehiculo instanceof Moto) {
				motosOrdenadas.add((Moto) vehiculo);
			}
		}
		
		return motosOrdenadas;
		
	}

	public Vehiculo buscarVehiculoPorId(Integer idBuscado) {
		
		for (Vehiculo vehiculo : listadoDeVehiculos) {
			if(vehiculo.getNumeroUnico().equals(idBuscado)) {
				return vehiculo;
			}
			
		}
		return null;
	}

	public Boolean alquilarVehiculo(Cliente cliente1, Vehiculo vehiculoAAlquilar, Integer tiempoAlquiler) throws NoDisponibleException {
		Cliente clienteQueAlquila = buscarClientePorDni(cliente1.getDni());
		
		Vehiculo alquilado = buscarVehiculoPorId(vehiculoAAlquilar.getNumeroUnico());
		
		if (alquilado.getEstaDisponible()== false) {
			throw new NoDisponibleException("El vehiculo no esta disponible para alquilar");	
		}
		
		Alquiler nuevo = new Alquiler(clienteQueAlquila, alquilado, tiempoAlquiler);
	
		alquilado.setEstaDisponible(false);
		return 	this.listadoDeAlquileres.add(nuevo);
		
	}
	
	
	public Cliente buscarClientePorDni(Integer dni) {
		
		for (Cliente cliente : listadoDeClientes) {
			if( cliente.getDni().equals(dni))
			 return cliente;
			
		}
		return null;
	}

	
	public HashMap<Cliente, ArrayList<Vehiculo>> obtenerReportePorCliente() {
		
		HashMap<Cliente, ArrayList<Vehiculo>> reporte = new HashMap <>();
		
		for (Alquiler alquiler : listadoDeAlquileres) {
			
			Cliente cli = alquiler.getCliente();
			Vehiculo vehiculoAlquilado = alquiler.getVehiculo();
			
			if(!reporte.containsKey(cli)) {
				ArrayList <Vehiculo> listadoVehiculosAlquilados = new ArrayList <>();
				listadoVehiculosAlquilados.add(vehiculoAlquilado);
				reporte.put(cli, listadoVehiculosAlquilados);
			}
			else {
				reporte.get(cli).add(vehiculoAlquilado);
			}
			
		}
		
		return reporte;
		
	}
	
	
	
	
}
