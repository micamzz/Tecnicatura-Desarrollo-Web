package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class GestorMaquinaVirtuales {

	private TreeSet <Usuario> listadoDeUsuarios;
	private TreeSet<MaquinaVirtual> listadoDeMaquinasVirtual;
	
	
	public GestorMaquinaVirtuales() {
		this.listadoDeUsuarios = new TreeSet <>();
	this.listadoDeMaquinasVirtual = new TreeSet <>();
	}
	
	
	public Boolean agregarUsuario(Usuario usuarioNuevo) throws CorreoDuplicadoException  {
		
            Boolean agregado = this.listadoDeUsuarios.add(usuarioNuevo);
            
            if(!agregado) {
            	throw new CorreoDuplicadoException("Correo duplicado");
            }
            
//            if (!this.listadoDeUsuarios.add(usuarioNuevo)) {
//            	throw new CorreoDuplicadoException("Correo duplicado");
//            }
            
    
            return agregado;  
	}
	
	
	public TreeSet <Usuario> obtenerUsuariosOrdenados(){
		
		return this.listadoDeUsuarios;
	
	}


	public Boolean agregarMaquinaVirtual(Usuario usuario, MaquinaVirtual maquina) {
		
		if (!buscarUsuarioPorCorreo(usuario.getCorreo())) return false;
		
		maquina.setUsuario(usuario);
		return this.listadoDeMaquinasVirtual.add(maquina);		
	}
	
	
	
	public Boolean buscarUsuarioPorCorreo(String correo) {
		for (Usuario usuarios: listadoDeUsuarios) {
			if(usuarios.getCorreo().equalsIgnoreCase(correo)) {
				return true;
			}	
		}	
		return false;
	}

	
	public void usarMaquinaVirtualBDD(BaseDeDato maquina , Integer horasDeUso) throws CantidadDeHorasDeUsoExcedidaException {
		
		  if (horasDeUso <= maquina.getLIMITE_DE_USO_EN_HS()) {
		        maquina.setHorasDeUso(horasDeUso);
		    } else {
		     
		        throw new CantidadDeHorasDeUsoExcedidaException("Horas excedidas");
		    }
	}
	
	public void usarMaquinaImg(ImagenVM maquina,Integer escritura, Integer lectura ) throws CantidadDeEscriturasSuperadaException , CantidadDeLecturaSuperadaException{
		
	
		if (maquina.getLIMITE_DE_ESCRITURAS() < escritura) {
			throw new CantidadDeEscriturasSuperadaException ("Cantidad maxima de escrituras");
		}
		
		
		if (maquina.getLIMITE_DE_LECTURAS() < lectura) {
			throw new CantidadDeLecturaSuperadaException("Cantidad maxima de escrituras");
		}
		
		maquina.setHorasEscritura(escritura);
        maquina.setHoraslectura(lectura);		
	}
	

	public TreeMap<Usuario, TreeSet<Double>> reporteDeUso() {
	    TreeMap<Usuario, TreeSet<Double>> reporte = new TreeMap<>();


	    for (MaquinaVirtual maquina : listadoDeMaquinasVirtual) {
	        Usuario usuario = maquina.getUsuario();

	        Double costo = maquina.calcularCostoTotal();
	        /*
	         * Si el mapa no contiene al usuario, creo un nuevo TreeSet con un
	         * Comparator RESERVER ORDER QUE ORDENA DE MAYOR A MENOR 
	         * Luego agrego el costo actual.
	         */
	        if (!reporte.containsKey(usuario)) {
	        
	      TreeSet<Double> costos = new TreeSet<>(Comparator.reverseOrder());
	            costos.add(costo);
	            reporte.put(usuario, costos);
	            
	        } else {
	        
	            reporte.get(usuario).add(costo);
	        }
	    }

	    return reporte;
	}
	
	
	public TreeMap<Usuario, TreeSet<Double>> reporteDeUsoMV() {

	    TreeMap<Usuario, TreeSet<Double>> reporte = new TreeMap<>();


	    for (MaquinaVirtual maquina : listadoDeMaquinasVirtual) {
	        Usuario usuario = maquina.getUsuario();

	        Double costo = maquina.calcularCostoTotal();
	        /*
	         * Si el mapa no contiene al usuario, creo un nuevo TreeSet con un
	         * Comparator que ordene los costos de forma descendente (de mayor a menor).
	         * Luego agrego el costo actual.
	         */
	        if (!reporte.containsKey(usuario)) {
	        
	      TreeSet<Double> costos = new TreeSet<>(new PrecioOrdenadosDescendente());
	            costos.add(costo);
	            reporte.put(usuario, costos);
	            
	        } else {
	        
	            reporte.get(usuario).add(costo);
	        }
	    }

	    return reporte;
	}
}
	

