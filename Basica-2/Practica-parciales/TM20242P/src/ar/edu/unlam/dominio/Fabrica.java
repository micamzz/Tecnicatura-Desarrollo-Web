package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Fabrica {

	ArrayList <Copa> listadoDeCopas;
	TreeSet <Cliente> listadoDeClientes;
	TreeMap <Cliente , ArrayList <Copa>> listadoDeVentas;

	
	public Fabrica() {
		this.listadoDeCopas = new ArrayList <>();
		this.listadoDeClientes = new TreeSet <>();	
		this.listadoDeVentas = new TreeMap <Cliente, ArrayList<Copa>> ();
	}
	
	public Boolean agregarCopaDelMundo(Copa copaNueva) {
		return this.listadoDeCopas.add(copaNueva);
	}
	
	public Integer obtenerCantidadDeCopas() {
		return this.listadoDeCopas.size();
	}
	
	
	public Boolean agregarCliente(Cliente clienteNuevo) throws ClienteDuplicadoException {
		if(!this.listadoDeClientes.add(clienteNuevo)){
			throw new ClienteDuplicadoException("Cliente duplicado");
		}
		
		return true;
	
	}
	
	
	public ArrayList <CopaEstandar> obtenerCopasDelMundoEstadandar(){
		ArrayList <CopaEstandar> listadoNuevo = new ArrayList <> ();
		for (Copa copas: listadoDeCopas) {
			if ( copas instanceof CopaEstandar) {
				listadoNuevo.add((CopaEstandar) copas);	
			}	
		}	
		return listadoNuevo;
	}

	public Copa obtenerCopaPorId(Integer idBuscado) throws CopaDelMundoNoEncontradaException {
		for (Copa copas: listadoDeCopas) {
			if( copas.getId().equals(idBuscado))
				return copas;
			}
		
	 throw new CopaDelMundoNoEncontradaException ("Copa no encontrada");
}
	
	
	public void realizarUnaVenta(Cliente cliente, Copa copaComprada) throws CopaDelMundoNoEncontradaException {

		ArrayList <Copa> copasCliente = this.listadoDeVentas.get(cliente);
		
		if (copasCliente == null) {
			copasCliente = new ArrayList <> ();
			listadoDeVentas.put(cliente, copasCliente);
		}
		
		copasCliente.add(copaComprada);
		if (copaComprada instanceof CopaEstandar) {
			((CopaEstandar)copaComprada).restarStock();
		}
		
		if (copaComprada instanceof CopaPersonalizada) {
			this.listadoDeCopas.remove(copaComprada);
			}
			
		}
	
	

	
public Double calcularPrecioFinal() {
	
	Double precioFinal=0D;
	
	for (Copa copas: listadoDeCopas) {
		
		if (copas instanceof CopaEstandar) {
			precioFinal += copas.obtenerPrecio();
		} else if
			(copas instanceof CopaPersonalizada){
			precioFinal += copas.obtenerPrecio();
			
		}
		
	}
	
	return precioFinal;
}


public TreeMap <Cliente, ArrayList <CopaEstandar>> obtenerReporteEstandar(){
	
	TreeMap <Cliente, ArrayList <CopaEstandar>> reportes = new TreeMap <>();
	
  for (Entry<Cliente, ArrayList<Copa>>  entry : listadoDeVentas.entrySet()) {
	Cliente cliente = entry.getKey();
	ArrayList<Copa> copasVendidas = entry.getValue();
	
	ArrayList<CopaEstandar> copasEstandar = new ArrayList<>();

    for (Copa c : copasVendidas) {
        if (c instanceof CopaEstandar) {
            copasEstandar.add((CopaEstandar) c);
        }
    }

    if (!copasEstandar.isEmpty()) {
        reportes.put(cliente, copasEstandar);
    }
}

return reportes;
}

public Integer chequearStock() {

	return CopaEstandar.getStock();
}

}
	
	


	

