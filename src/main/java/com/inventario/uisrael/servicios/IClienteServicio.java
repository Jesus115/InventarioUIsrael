package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.Cliente;


@Service
public interface IClienteServicio {
	public Optional<Cliente> buscarClienteId(int idCliente);
	public boolean eliminarClienteId(int idCliente);
	public List<Cliente> listarCliente();
	public void insertarCliente(Cliente nuevoCliente);
	public void actualizarCliente(Cliente editarCliente);
}
