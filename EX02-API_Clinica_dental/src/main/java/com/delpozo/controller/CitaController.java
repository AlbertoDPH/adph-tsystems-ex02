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

@RestController
@RequestMapping("/api")
public class CitaController {

	@Autowired
	CitaServiceImpl citaServiceImpl;

	@GetMapping("/citas")
	public List<Cita> listarCita() {
		return citaServiceImpl.listarCita();
	}

	@PostMapping("/citas")
	public Cita salvarCita(@RequestBody Cita cita) {
		return citaServiceImpl.guardarCita(cita);
	}

	@GetMapping("/citas/{id}")
	public Cita citaXID(@PathVariable(name = "id") Integer id) {

		Cita cita_xid = new Cita();

		cita_xid = citaServiceImpl.citaXID(id);

		System.out.println("Cita XID: " + cita_xid);

		return cita_xid;
	}

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

	@DeleteMapping("/citas/{id}")
	public void eliminarCita(@PathVariable(name = "id") Integer id) {
		citaServiceImpl.eliminarCita(id);
	}

}
