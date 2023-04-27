package com.delpozo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Dentista;
import com.delpozo.dto.Cita;

public interface IDentistaDAO extends JpaRepository<Dentista, Integer>{
//	List<Cita> findByDentistaId(Integer dentistaId);

}
