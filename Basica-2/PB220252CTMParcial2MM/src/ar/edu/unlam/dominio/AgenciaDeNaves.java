package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import ar.edu.unlam.excepciones.IdDuplicadoException;
import ar.edu.unlam.excepciones.NoSeEncuentraMisionConIdExcepcion;
import ar.edu.unlam.excepciones.TonelajeDeCargaExcecidoException;

public class AgenciaDeNaves {
	
	private HashSet <Nave> listadoDeNaves;
	private ArrayList<Mision> listadoDeMisiones;
	
	
	public AgenciaDeNaves () {
	this.listadoDeNaves = new HashSet <>();
	this.listadoDeMisiones = new ArrayList <>();
	}


	public Boolean agregarNave(Nave nave1) throws TonelajeDeCargaExcecidoException, IdDuplicadoException{
		
		existeLaNave(nave1.getIdUnico());
		
		if(nave1 instanceof NaveCarguera && ((NaveCarguera)nave1).getTonelajeDeCarga() >30D) {
			throw new TonelajeDeCargaExcecidoException("excedido");
		}
	return this.listadoDeNaves.add(nave1);
	}
	
	
	public void existeLaNave(String id) throws IdDuplicadoException{

		for (Nave naves : listadoDeNaves) {
			if(naves.getIdUnico().equalsIgnoreCase(id)) {
				throw new IdDuplicadoException("El id ya se esa nave ya se encuentra registrado");
			}		
		}
				
	}

	public Boolean realizarMision(Mision mision1) {
		
		if(mision1.getNave().getCapacidadMaximaCombustible() < mision1.obtenerConsulmoDeCombustiblePorMision()) {
			return false;
		}
		
					
return this.listadoDeMisiones.add(mision1);
	}
	
	
	
	public Mision obtenerMisionPorId(Integer id) throws NoSeEncuentraMisionConIdExcepcion {
		
		for (Mision mision : listadoDeMisiones) {
			if (mision.getId().equals(id))
			return mision;
			
		}
		throw new NoSeEncuentraMisionConIdExcepcion("No existe mision con ese ID");
	}


	public TreeSet<Nave> obtenerListadoDeNavesOrdenadasPorIDAsc() {
		TreeSet<Nave> listadoDeNavesOrdenadas = new TreeSet <> (new NavesOrdenadasPorId());
		
		listadoDeNavesOrdenadas.addAll(listadoDeNaves);
	
		return listadoDeNavesOrdenadas;
	}


	public TreeSet<Nave> obtenerListadoDeNavesOrdenadasPorNombreDesc() {
TreeSet<Nave> listadoDeNavesOrdenadasNombre = new TreeSet <> (new NavesOrdenadasPorNombreDesc());
		
		listadoDeNavesOrdenadasNombre.addAll(listadoDeNaves);
	
		return listadoDeNavesOrdenadasNombre;
	}


	public HashMap<Nave, ArrayList<Mision>> obtenerReporteDeLasMisiones() {
		HashMap<Nave, ArrayList<Mision>>  reporte = new HashMap <>();
		
		
		for (Mision mision : listadoDeMisiones) {
			Nave nave1 = mision.getNave();
			
			if(!reporte.containsKey(nave1)) {
				ArrayList <Mision> listadoMisiones = new ArrayList <>();
				listadoMisiones.add(mision);
				reporte.put(nave1, listadoMisiones);		
			} else {
				
				reporte.get(nave1).add(mision);
			}
					
		}
			
		return reporte;
		
	}

	

	
	
	
	
	

}
