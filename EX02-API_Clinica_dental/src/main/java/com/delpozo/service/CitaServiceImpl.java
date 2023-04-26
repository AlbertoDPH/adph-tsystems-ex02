package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.ICitaDAO;
import com.delpozo.dto.Cita;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	ICitaDAO iCitaDAO;
	
	@Override
	public List<Cita> listarCita() {
		
		return iCitaDAO.findAll();
	}

	@Override
	public Cita guardarCita(Cita cita) {
		
		return iCitaDAO.save(cita);
	}

	@Override
	public Cita citaXID(Integer id) {
		
		return iCitaDAO.findById(id).get();
	}

	@Override
	public Cita actualizarCita(Cita cita) {
	
		return iCitaDAO.save(cita);
	}

	@Override
	public void eliminarCita(Integer id) {
	
		iCitaDAO.deleteById(id);
	}

}
