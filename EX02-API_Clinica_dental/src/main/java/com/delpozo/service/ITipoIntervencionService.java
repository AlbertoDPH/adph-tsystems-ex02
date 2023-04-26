package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.TipoIntervencion;

public interface ITipoIntervencionService {
	
	//Metodos del CRUD
		public List<TipoIntervencion> listarTipoIntervencion(); // Listar All

		public TipoIntervencion guardarTipoIntervencion(TipoIntervencion tipoIntervencion); // Guarda un tipoIntervencion CREATE

		public TipoIntervencion tipoIntervencionXID(Integer id); // Leer datos de un tipoIntervencion READ

		public TipoIntervencion actualizarTipoIntervencion(TipoIntervencion tipoIntervencion); // Actualiza datos del tipoIntervencion UPDATE

		public void eliminarTipoIntervencion(Integer id);// Elimina el tipoIntervencion DELETE

}
