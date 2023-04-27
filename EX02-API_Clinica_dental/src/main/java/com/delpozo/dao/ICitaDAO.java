package com.delpozo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delpozo.dto.Cita;

/**
 * Interfaz de tipo ICitaDAO que extide de JpaRepository
 * Hereda entre otros los metodos para gestionar las citas en la bbdd
 * 
 * @author Alberto
 *
 */
public interface ICitaDAO extends JpaRepository<Cita, Integer>{
	List<Cita> findByDentistaId(Integer dentistaId); //obtine las citas de un dentista

}
