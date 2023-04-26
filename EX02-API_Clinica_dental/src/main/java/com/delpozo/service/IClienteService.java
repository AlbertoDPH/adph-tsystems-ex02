package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Cliente;

public interface IClienteService {
	
	//Metodos del CRUD
		public List<Cliente> listarCliente(); // Listar All

		public Cliente guardarCliente(Cliente cliente); // Guarda un cliente CREATE

		public Cliente clienteXID(Integer id); // Leer datos de un cliente READ

		public Cliente actualizarCliente(Cliente cliente); // Actualiza datos del cliente UPDATE

		public void eliminarCliente(Integer id);// Elimina el cliente DELETE

}
