package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.ITipoIntervencionDAO;
import com.delpozo.dto.TipoIntervencion;

@Service
public class TipoIntervencionServiceImpl implements ITipoIntervencionService{

	@Autowired
	ITipoIntervencionDAO iTipoIntervencionDAO;
	
	@Override
	public List<TipoIntervencion> listarTipoIntervencion() {
		
		return iTipoIntervencionDAO.findAll();
	}

	@Override
	public TipoIntervencion guardarTipoIntervencion(TipoIntervencion tipoIntervencion) {
		
		return iTipoIntervencionDAO.save(tipoIntervencion);
	}

	@Override
	public TipoIntervencion tipoIntervencionXID(Integer id) {
		
		return iTipoIntervencionDAO.findById(id).get();
	}

	@Override
	public TipoIntervencion actualizarTipoIntervencion(TipoIntervencion tipoIntervencion) {
	
		return iTipoIntervencionDAO.save(tipoIntervencion);
	}

	@Override
	public void eliminarTipoIntervencion(Integer id) {
	
		iTipoIntervencionDAO.deleteById(id);
	}

}
