package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IDentistaDAO;
import com.delpozo.dto.Cita;
import com.delpozo.dto.Dentista;

@Service
public class DentistaServiceImpl implements IDentistaService{

	@Autowired
	IDentistaDAO iDentistaDAO;
	
	@Override
	public List<Dentista> listarDentista() {
		
		return iDentistaDAO.findAll();
	}

	@Override
	public Dentista guardarDentista(Dentista dentista) {
		
		return iDentistaDAO.save(dentista);
	}

	@Override
	public Dentista dentistaXID(Integer id) {
		
		return iDentistaDAO.findById(id).get();
	}

	@Override
	public Dentista actualizarDentista(Dentista dentista) {
	
		return iDentistaDAO.save(dentista);
	}

	@Override
	public void eliminarDentista(Integer id) {
	
		iDentistaDAO.deleteById(id);
	}
	
//	@Override
//    public List<Cita> findCitasByDentistaId(Integer id) {
//        return iDentistaDAO.findByDentistaId(id);
//    }

}
