package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IClienteDAO;
import com.delpozo.dto.Cita;
import com.delpozo.dto.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteDAO iClienteDAO;
	
	@Override
	public List<Cliente> listarCliente() {
		
		return iClienteDAO.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		
		return iClienteDAO.save(cliente);
	}

	@Override
	public Cliente clienteXID(Integer id) {
		
		return iClienteDAO.findById(id).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
	
		return iClienteDAO.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
	
		iClienteDAO.deleteById(id);
	}
	
	
	
	
	
	

}
