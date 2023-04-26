package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Dentista;

public interface IDentistaService {
	
	//Metodos del CRUD
		public List<Dentista> listarDentista(); // Listar All

		public Dentista guardarDentista(Dentista dentista); // Guarda un dentista CREATE

		public Dentista dentistaXID(Integer id); // Leer datos de un dentista READ

		public Dentista actualizarDentista(Dentista dentista); // Actualiza datos del dentista UPDATE

		public void eliminarDentista(Integer id);// Elimina el dentista DELETE

}
