package com.delpozo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delpozo.dto.Cliente;
import com.delpozo.service.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	ClienteServiceImpl clienteServiceImpl;

	@GetMapping("/clientes")
	public List<Cliente> listarCliente() {
		return clienteServiceImpl.listarCliente();
	}

	@PostMapping("/clientes")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteServiceImpl.guardarCliente(cliente);
	}

	@GetMapping("/clientes/{id}")
	public Cliente clienteXID(@PathVariable(name = "id") Integer id) {

		Cliente cliente_xid = new Cliente();

		cliente_xid = clienteServiceImpl.clienteXID(id);

		System.out.println("Cliente XID: " + cliente_xid);

		return cliente_xid;
	}

	@PutMapping("/clientes/{id}")
	public Cliente actualizarCliente(@PathVariable(name = "id") Integer id,
			@RequestBody Cliente cliente) {

		Cliente cliente_seleccionado = new Cliente();
		Cliente cliente_actualizado = new Cliente();

		cliente_seleccionado = clienteServiceImpl.clienteXID(id);

		cliente_seleccionado.setNombre(cliente.getNombre());
		cliente_seleccionado.setApellido(cliente.getApellido());
		cliente_seleccionado.setEmail(cliente.getEmail());
		cliente_seleccionado.setContrasena(cliente.getContrasena());
		
		cliente_actualizado = clienteServiceImpl.actualizarCliente(cliente_seleccionado);

		System.out.println("La cliente actualizada es: " + cliente_actualizado);

		return cliente_actualizado;
	}

	@DeleteMapping("/clientes/{id}")
	public void eliminarCliente(@PathVariable(name = "id") Integer id) {
		clienteServiceImpl.eliminarCliente(id);
	}

}
