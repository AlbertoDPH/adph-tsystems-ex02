package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.TipoIntervencion;

public interface ITipoIntervencionDAO extends JpaRepository<TipoIntervencion, Integer>{

}
