package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Reserva {

		private static Integer proximoId = 0;
		private Integer id;
		private Paciente paciente;
	    private Medico medico;
	    private LocalDateTime fechaYHoraInicio;
	    private LocalDateTime fechaYHoraFinal;
	    private Double costoConsulta; //costo de la consulta proviene del copago
	    
	    
	    public Reserva (Paciente paciente,Medico medico ,LocalDateTime fechaYHora, Double costoConsulta) {
	    	this.paciente = paciente;
	    	this.medico = medico;
	    	this.fechaYHoraInicio = fechaYHora;
	    	this.fechaYHoraFinal = fechaYHora.plusMinutes(15); // PARA QUE EL TURNO DURE 15 MINUTOS
	    	this.id = ++proximoId; // ID AUTOINCREMENTAL. PARA BUSCAR POR ID LA RESERVA. 
	    	this.costoConsulta = costoConsulta;
	    }
	 
	    
		public Integer getId() {
			return id;
		}

		public Paciente getPaciente() {
			return paciente;
		}

		public Medico getMedico() {
			return medico;
		}

		
		public LocalDateTime getFechaYHoraInicio() {
			return fechaYHoraInicio;
		}
		
		
		public LocalDateTime getFechaYHoraFinal() {
			return fechaYHoraFinal;
		}
		

		
	    
	    
	}

