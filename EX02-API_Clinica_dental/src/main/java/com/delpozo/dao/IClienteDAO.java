package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Cliente;

public interface IClienteDAO extends JpaRepository<Cliente, Integer>{

}
