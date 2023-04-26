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

import com.delpozo.dto.TipoIntervencion;
import com.delpozo.service.TipoIntervencionServiceImpl;

@RestController
@RequestMapping("/api")
public class TipoIntervencionController {

	@Autowired
	TipoIntervencionServiceImpl tipoIntervencionServiceImpl;

	@GetMapping("/tipo_intervenciones")
	public List<TipoIntervencion> listarTipoIntervencion() {
		return tipoIntervencionServiceImpl.listarTipoIntervencion();
	}

	@PostMapping("/tipo_intervenciones")
	public TipoIntervencion salvarTipoIntervencion(@RequestBody TipoIntervencion tipoIntervencion) {
		return tipoIntervencionServiceImpl.guardarTipoIntervencion(tipoIntervencion);
	}

	@GetMapping("/tipo_intervenciones/{id}")
	public TipoIntervencion tipoIntervencionXID(@PathVariable(name = "id") Integer id) {

		TipoIntervencion tipoIntervencion_xid = new TipoIntervencion();

		tipoIntervencion_xid = tipoIntervencionServiceImpl.tipoIntervencionXID(id);

		System.out.println("TipoIntervencion XID: " + tipoIntervencion_xid);

		return tipoIntervencion_xid;
	}

	@PutMapping("/tipo_intervenciones/{id}")
	public TipoIntervencion actualizarTipoIntervencion(@PathVariable(name = "id") Integer id,
			@RequestBody TipoIntervencion tipoIntervencion) {

		TipoIntervencion tipoIntervencion_seleccionado = new TipoIntervencion();
		TipoIntervencion tipoIntervencion_actualizado = new TipoIntervencion();

		tipoIntervencion_seleccionado = tipoIntervencionServiceImpl.tipoIntervencionXID(id);

		tipoIntervencion_seleccionado.setNombre(tipoIntervencion.getNombre());
		tipoIntervencion_seleccionado.setDescripcion(tipoIntervencion.getDescripcion());
		tipoIntervencion_seleccionado.setDuracionEstimada(tipoIntervencion.getDuracionEstimada());
		
		tipoIntervencion_actualizado = tipoIntervencionServiceImpl.actualizarTipoIntervencion(tipoIntervencion_seleccionado);

		System.out.println("La tipoIntervencion actualizada es: " + tipoIntervencion_actualizado);

		return tipoIntervencion_actualizado;
	}

	@DeleteMapping("/tipo_intervenciones/{id}")
	public void eliminarTipoIntervencion(@PathVariable(name = "id") Integer id) {
		tipoIntervencionServiceImpl.eliminarTipoIntervencion(id);
	}

}
