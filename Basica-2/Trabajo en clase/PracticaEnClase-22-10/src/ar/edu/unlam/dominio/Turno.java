package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Turno {

	private static Integer proximoId = 0;
	private Integer id;
	private Medico medico;
	private Paciente paciente;
	LocalDateTime fechaYHora;

	
	
	public Turno(Paciente paciente,Medico medico,LocalDateTime fechaTurno) {
		
		this.id = proximoId++;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaYHora = fechaTurno;
	}



	public Integer getId() {
		return id;
	}



	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}



	public Medico getMedico() {
		return medico;
	}



	public Paciente getPaciente() {
		return paciente;
	}
	
	
	
	
	
}
