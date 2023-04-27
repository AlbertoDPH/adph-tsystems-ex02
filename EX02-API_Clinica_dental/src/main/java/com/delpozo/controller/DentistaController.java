package com.delpozo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delpozo.dto.Dentista;
import com.delpozo.dto.Cita;
import com.delpozo.service.CitaServiceImpl;
import com.delpozo.service.DentistaServiceImpl;

/**
 * Clase controladora de la API REST para las peticiones HTTP relacionadas con dentitas.
 * @author Alberto
 *
 */

@RestController
@RequestMapping("/api")
public class DentistaController {

	@Autowired
	DentistaServiceImpl dentistaServiceImpl;
	
	@Autowired
	CitaServiceImpl citaServiceImpl;	//lo instanciamos para las citas del dentista

	@GetMapping("/dentistas")
	public List<Dentista> listarDentista() {
		return dentistaServiceImpl.listarDentista();
	}

	@PostMapping("/dentistas")
	public Dentista salvarDentista(@RequestBody Dentista dentista) {
		return dentistaServiceImpl.guardarDentista(dentista);
	}

	@GetMapping("/dentistas/{id}")
	public Dentista dentistaXID(@PathVariable(name = "id") Integer id) {

		Dentista dentista_xid = new Dentista();

		dentista_xid = dentistaServiceImpl.dentistaXID(id);

		System.out.println("Dentista XID: " + dentista_xid);

		return dentista_xid;
	}
	/**
	 * lo usaremos para controlar la las peticiones GET de las citas de un dentista
	 * @param id
	 */
    @GetMapping("dentistas/{id}/citas")
    public ResponseEntity<List<Cita>> getCitasByDentistaId(@PathVariable("id") Integer id) {
        List<Cita> citas = citaServiceImpl.findCitasByDentistaId(id);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

	@PutMapping("/dentistas/{id}")
	public Dentista actualizarDentista(@PathVariable(name = "id") Integer id,
			@RequestBody Dentista dentista) {

		Dentista dentista_seleccionado = new Dentista();
		Dentista dentista_actualizado = new Dentista();

		dentista_seleccionado = dentistaServiceImpl.dentistaXID(id);

		dentista_seleccionado.setNombre(dentista.getNombre());
		dentista_seleccionado.setApellido(dentista.getApellido());
		dentista_seleccionado.setEmail(dentista.getEmail());
		dentista_seleccionado.setContrasena(dentista.getContrasena());
		dentista_seleccionado.setEspecialidad(dentista.getEspecialidad());
		
		dentista_actualizado = dentistaServiceImpl.actualizarDentista(dentista_seleccionado);

		System.out.println("La dentista actualizada es: " + dentista_actualizado);

		return dentista_actualizado;
	}

	@DeleteMapping("/dentistas/{id}")
	public void eliminarDentista(@PathVariable(name = "id") Integer id) {
		dentistaServiceImpl.eliminarDentista(id);
	}

}
