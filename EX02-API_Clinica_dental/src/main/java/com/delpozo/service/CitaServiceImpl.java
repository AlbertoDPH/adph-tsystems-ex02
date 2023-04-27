package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.ICitaDAO;
import com.delpozo.dto.Cita;

/**
 * Implementa la interfaz ICitaService y se encarga de realizar las operaciones
 * CRUD en la bbdd
 * 
 * @author Alberto
 *
 */
@Service
public class CitaServiceImpl implements ICitaService {

	/**
	 * Busca con Spring un componente de una instancia de la interfaz ICitaDAO y lo
	 * inyecte en iCitaDAO
	 */
	@Autowired
	ICitaDAO iCitaDAO;

	/**
	 * devuelve una lista con todas las citas que existen en la bbdd
	 * 
	 * @return
	 */
	@Override
	public List<Cita> listarCita() {

		return iCitaDAO.findAll();
	}

	/**
	 * recibe un objeto de tipo Cita y lo guarda en la bbdd, nos sirve para añadir
	 * registros en la bbdd
	 * 
	 * @param cita
	 * @return
	 */
	@Override
	public Cita guardarCita(Cita cita) {

		return iCitaDAO.save(cita);
	}

	/**
	 * recibe un id de cita por parametro y lo busca en la bbdd, si lo encuentra
	 * devuelve el objeto Cita y lo muestra
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Cita citaXID(Integer id) {

		return iCitaDAO.findById(id).get();
	}

	/**
	 * se le pasa un id Cita y recibe un objeto Cita con la info actualizada del
	 * objeto.
	 * 
	 * @param cita
	 * @return
	 */
	@Override
	public Cita actualizarCita(Cita cita) {

		return iCitaDAO.save(cita);
	}

	/**
	 * se le pasa un id Cita y recibe un objeto Cita con la info actualizada del
	 * objeto.
	 * 
	 * @param cita
	 * @return
	 */
	@Override
	public void eliminarCita(Integer id) {

		iCitaDAO.deleteById(id);
	}

	@Override
	public List<Cita> findCitasByDentistaId(Integer id) {
		return iCitaDAO.findByDentistaId(id);
	}

}
