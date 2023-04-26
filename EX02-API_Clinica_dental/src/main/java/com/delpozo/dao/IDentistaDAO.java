package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Dentista;

public interface IDentistaDAO extends JpaRepository<Dentista, Integer>{

}
