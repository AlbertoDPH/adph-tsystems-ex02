package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Cita;

/**
 * Interfaz que nos servira para implementar los metodos CRUD que se utilizan
 * para manejar las citas en la app y que se desarrollaran cunado sea llamada la
 * interfaz ICitaService
 * 
 * @author Alberto
 *
 */
public interface ICitaService {

	// Metodos del CRUD

	/**
	 * devuelve una lista con todas las citas que existen en la bbdd
	 * 
	 * @return
	 */
	public List<Cita> listarCita(); // Listar All

	/**
	 * recibe un objeto de tipo Cita y lo guarda en la bbdd, nos sirve para añadir
	 * registros en la bbdd
	 * 
	 * @param cita
	 * @return
	 */
	public Cita guardarCita(Cita cita); // Guarda un cita CREATE

	/**
	 * recibe un id de cita por parametro y lo busca en la bbdd, si lo encuentra
	 * devuelve el objeto Cita y lo muestra
	 * 
	 * @param id
	 * @return
	 */
	public Cita citaXID(Integer id); // Leer datos de un cita READ

	/**
	 * se le pasa un id Cita y recibe un objeto Cita con la info actualizada del
	 * objeto.
	 * 
	 * @param cita
	 * @return
	 */
	public Cita actualizarCita(Cita cita); // Actualiza datos del cita UPDATE

	/**
	 * se le pasa un id Cita y recibe un objeto Cita con la info actualizada del
	 * objeto.
	 * 
	 * @param cita
	 * @return
	 */
	public void eliminarCita(Integer id);// Elimina el cita DELETE
	
	public List<Cita> findCitasByDentistaId(Integer dentistaId); //busca citas por dentista


}
