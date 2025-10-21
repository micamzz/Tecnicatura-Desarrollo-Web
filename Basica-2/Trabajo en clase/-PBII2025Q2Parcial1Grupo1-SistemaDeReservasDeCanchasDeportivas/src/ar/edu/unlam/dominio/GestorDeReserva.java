package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GestorDeReserva {

	private Set<Cancha> canchas;
	private HashSet<ReservaBase> reservas;
	private static Integer proximoIdCancha = 1;
	private static Integer proximoIdReserva = 1;

	// Declararlo de tipo Set y luego lo instanciamos en Treeset o Hashset por polimorfismo. 
	public GestorDeReserva() {
		this.canchas = new TreeSet<>();
		this.reservas = new HashSet<>();
	}

	public Boolean agregarCancha(Cancha cancha) {
		cancha.setIdCancha(proximoIdCancha);
		proximoIdCancha++;
		return this.canchas.add(cancha);
	}

	public Boolean agregarReserva(ReservaBase nuevaReserva) {
		if (!hayHorarioSuperpuesto(nuevaReserva)) {
			nuevaReserva.setIdReserva(proximoIdReserva);
			proximoIdReserva++;
			return reservas.add(nuevaReserva);
		}
		return false;
	}

	private Boolean hayHorarioSuperpuesto(ReservaBase nuevaReserva) {
		for (ReservaBase reservaExistente : this.reservas) {
			if (reservaExistente.getCancha().equals(nuevaReserva.getCancha())) {
				if (yaSeReservoLaCanchaEnEseRangoHorario(reservaExistente, nuevaReserva)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean yaSeReservoLaCanchaEnEseRangoHorario(ReservaBase reservaExistente, ReservaBase nuevaReserva) {

		LocalDateTime inicioReservaExistente = reservaExistente.getHoraInicio();
		LocalDateTime finalReservaExistente = reservaExistente.getHoraFinal();

		LocalDateTime inicioNuevaReserva = nuevaReserva.getHoraInicio();
		LocalDateTime finalNuevaReserva = nuevaReserva.getHoraFinal();

		Boolean reservaExistenteEmpiezaCuandoTerminaNuevaReserva = inicioReservaExistente.isBefore(finalNuevaReserva);
		Boolean reservaExistenteTerminaCuandoEmpiezaNuevaReserva = finalReservaExistente.isAfter(inicioNuevaReserva);

		return reservaExistenteEmpiezaCuandoTerminaNuevaReserva && reservaExistenteTerminaCuandoEmpiezaNuevaReserva;
	}
	
	private boolean yaSeReservoLaCanchaEnEseRangoHorarioConLocalDate(ReservaBase reservaExistente, LocalDateTime momentoInicio) {
		
		LocalDateTime inicioReservaExistente = reservaExistente.getHoraInicio();
		LocalDateTime finalReservaExistente = reservaExistente.getHoraFinal();
		
		LocalDateTime inicioNuevaReserva = momentoInicio;
		LocalDateTime finalNuevaReserva = momentoInicio.plusHours(1);
		
		Boolean reservaExistenteEmpiezaCuandoTerminaNuevaReserva = inicioReservaExistente.isBefore(finalNuevaReserva);
		Boolean reservaExistenteTerminaCuandoEmpiezaNuevaReserva = finalReservaExistente.isAfter(inicioNuevaReserva);
		
		return reservaExistenteEmpiezaCuandoTerminaNuevaReserva && reservaExistenteTerminaCuandoEmpiezaNuevaReserva;
	}

	public Double finalizarReserva(Integer IdDeReserva) {
		ReservaBase reservaAFinalizar = obtenerReservaPorId(IdDeReserva);
		this.reservas.remove(reservaAFinalizar);
		return reservaAFinalizar.calcularPrecioFinal();
	}

	public ReservaBase obtenerReservaPorId(Integer idABuscar) {
		ReservaBase reservaEncontrada = null;
		for (ReservaBase reserva : this.reservas) {
			if (reserva.getIdReserva().equals(idABuscar)) {
				reservaEncontrada = reserva;
			}
		}
		return reservaEncontrada;
	}

	public Boolean cancelarReserva(ReservaBase reserva) {
		return this.reservas.remove(reserva);
	}
	public Boolean cancelarReservaPorId(Integer idReserva) {
		ReservaBase reservaACancelar = obtenerReservaPorId(idReserva);
		return cancelarReserva(reservaACancelar);
	}

	public Cancha obtenerCanchaPorId(Integer idCancha) {
		Cancha canchaEncontrada = null;
		for (Cancha cancha : this.canchas) {
			if (cancha.getIdCancha().equals(idCancha)) {
				canchaEncontrada = cancha;
			}
		}
		return canchaEncontrada;
	}

	public Set<Cancha> getCanchas() {
		return canchas;
	}

	public HashSet<ReservaBase> getReservas() {
		return reservas;
	}

	public HashSet<Cancha> obtenerCanchasReservadasConUnHorarioEspecifico(LocalDateTime horaDeInicio) {
		HashSet<Cancha> hashSetTemporalDeCanchasReservadas = new HashSet<>();

			for (ReservaBase reserva : reservas) {
				if (yaSeReservoLaCanchaEnEseRangoHorarioConLocalDate(reserva,horaDeInicio)) {
					hashSetTemporalDeCanchasReservadas.add(reserva.getCancha());
				}
			}
		
		return hashSetTemporalDeCanchasReservadas;
	}
	
	public HashSet<ReservaBase> obtenerReservasConUnHorarioEspecifico(LocalDateTime horaDeInicio) {
		HashSet<ReservaBase> hashSetTemporalDeCanchasReservadas = new HashSet<>();
		
		for (ReservaBase reserva : reservas) {
			if (yaSeReservoLaCanchaEnEseRangoHorarioConLocalDate(reserva,horaDeInicio)) {
				hashSetTemporalDeCanchasReservadas.add(reserva);
			}
			
		}
		return hashSetTemporalDeCanchasReservadas;
	}
	
	public HashSet<Cancha> obtenerCanchasDisponibles(LocalDateTime horaDeInicio) {
		HashSet<Cancha> hashSetTemporalDeCanchasDisponibles = new HashSet<>();
		ArrayList<Integer> IdDeCanchasReservadas = obtenerCanchasIdDeCanchasReservadas(horaDeInicio);
		
		for (Cancha cancha : this.canchas) {
			 if (!IdDeCanchasReservadas.contains(cancha.getIdCancha())) {
				 hashSetTemporalDeCanchasDisponibles.add(cancha);
		        }
		}
		
		return hashSetTemporalDeCanchasDisponibles;
	}
	
	public ArrayList<Integer> obtenerCanchasIdDeCanchasReservadas(LocalDateTime horaDeInicio) {
		ArrayList<Integer> IdDeCanchasReservadas = new ArrayList<>();
		
		for (Cancha cancha : obtenerCanchasReservadasConUnHorarioEspecifico(horaDeInicio)) {
			IdDeCanchasReservadas.add(cancha.getIdCancha());
		}
		
		return IdDeCanchasReservadas;
	}

	public TreeSet<Cancha> obtenerListadoDeCanchasDeFutbol5OrdenadasPorId() {
		
		TreeSet <Cancha> canchasF5Ordenadas =  new TreeSet <>();
		
		/* Genero un nuevo TreeSet donde guardar las canchas de futbol 5 
		 * Pregunto si cancha INSTANCE OF cancha de futbol 5 
		 * y si es asi lo agrego al nuevo TreeSet.
		 */
		for (Cancha cancha : canchas) {
			if (cancha instanceof CanchaDeFutbol5)
				canchasF5Ordenadas.add(cancha);
			}
		return canchasF5Ordenadas;
		}

	
	public TreeSet<Cancha> obtenerListadoDeCanchasPorPrecio() {
		TreeSet <Cancha> canchasOrdenadasPorPrecio =  new TreeSet <>(new OrdenCanchasPorPrecio());
		
		// Le agrego todas las canchas que hay en la coleccion
		canchasOrdenadasPorPrecio.addAll(this.canchas); 
		
		return canchasOrdenadasPorPrecio ;
	}

	public Map<Cliente, List<Cancha>> obtenerReporteClientesCanchas() {
		
		Map<Cliente, List<Cancha>> reporte = new HashMap<>();
		
		for (ReservaBase reservas : this.reservas) {
			
			Cliente cliente = reservas.getClienteTitular();
			Cancha cancha= reservas.getCancha();
			

			if (reporte.containsKey(cliente)) {
			 List <Cancha> valorMapa = 	reporte.get(cliente);
			 
			 valorMapa.add(cancha);
			 reporte.replace(cliente, valorMapa); // reemplaza el valor del mapa.
			}
			else {
				List <Cancha > list = new ArrayList <> ();
				list.add(cancha);
				reporte.put(cliente, list);
				
				// Coleccion de reservas
				// andres cancha1
				// mica cancha 2
				// mica cancha 3
				/*
				 *COMO DEBERIA QUEDAR EL MAPA- EL REPORTE
				 * un mapa con dos key. 
				 * andres una lista con cancha1
				 * mica una lista con dos objetos.(cancha 2 y 3)
				 * 
				
				 * 
				 * 
				 */
			}
		}
		
		return reporte;
	}
		
	
	
}
