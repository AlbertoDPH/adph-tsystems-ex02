package com.delpozo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delpozo.dto.Cita;
import com.delpozo.service.CitaServiceImpl;
/**
 * Clase controladora de la API REST para las peticiones HTTP relacionadas con citas.
 * @author Alberto
 *
 */

// controlador para manejar las peticiones HTTP
@RestController

// la utilizaremos para mapear las solitudes HTTP
@RequestMapping("/api")
public class CitaController {

	/**
	 * Busca con Spring un componente de una instancia de la clase CitaServiceImpl y lo 
	 * inyecte en citaServiceImpl
	 */
	@Autowired
	CitaServiceImpl citaServiceImpl;

	/**
	 * devuelve una lista con las citas que hay en la bbdd
	 * @return
	 */
	@GetMapping("/citas")
	public List<Cita> listarCita() {
		return citaServiceImpl.listarCita();
	}
	/**
	 * recibe una cita por marametro la guarda en el sistema
	 * luego retorna la cita guardada
	 * @param cita
	 * @return
	 */
	@PostMapping("/citas")
	public Cita salvarCita(@RequestBody Cita cita) {
		return citaServiceImpl.guardarCita(cita);
	}

	/**
	 * busca la cita por el ID pasado por parametro, si la encuentra la retorna
	 * si no retorna una cita vacia
	 * @param id
	 * @return
	 */
	@GetMapping("/citas/{id}")
	public Cita citaXID(@PathVariable(name = "id") Integer id) {

		Cita cita_xid = new Cita();

		cita_xid = citaServiceImpl.citaXID(id);

		System.out.println("Cita XID: " + cita_xid);

		return cita_xid;
	}
	/**
	 * busca la cita con esa ID en la bbdd, actualiza los campos con lo valores recibidos
	 * luego retorna la cita actualilzada
	 * @param id
	 * @param cita
	 * @return
	 */
	@PutMapping("/citas/{id}")
	public Cita actualizarCita(@PathVariable(name = "id") Integer id,
			@RequestBody Cita cita) {

		Cita cita_seleccionado = new Cita();
		Cita cita_actualizado = new Cita();

		cita_seleccionado = citaServiceImpl.citaXID(id);

		cita_seleccionado.setCliente(cita.getCliente());
		cita_seleccionado.setDentista(cita.getDentista());
		cita_seleccionado.setTipoIntervencion(cita.getTipoIntervencion());
		cita_seleccionado.setFechaHora(cita.getFechaHora());
		
		cita_actualizado = citaServiceImpl.actualizarCita(cita_seleccionado);

		System.out.println("La cita actualizada es: " + cita_actualizado);

		return cita_actualizado;
	}
	/**
	 * elimina la cita que contiene el ID pasado por parametro
	 * @param id
	 */
	@DeleteMapping("/citas/{id}")
	public void eliminarCita(@PathVariable(name = "id") Integer id) {
		citaServiceImpl.eliminarCita(id);
	}

}
