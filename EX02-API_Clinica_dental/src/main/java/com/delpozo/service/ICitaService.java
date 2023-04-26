package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Cita;

public interface ICitaService {
	
	//Metodos del CRUD
		public List<Cita> listarCita(); // Listar All

		public Cita guardarCita(Cita cita); // Guarda un cita CREATE

		public Cita citaXID(Integer id); // Leer datos de un cita READ

		public Cita actualizarCita(Cita cita); // Actualiza datos del cita UPDATE

		public void eliminarCita(Integer id);// Elimina el cita DELETE

}
