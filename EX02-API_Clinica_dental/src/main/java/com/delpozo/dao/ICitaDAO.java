package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delpozo.dto.Cita;

public interface ICitaDAO extends JpaRepository<Cita, Integer>{

}
