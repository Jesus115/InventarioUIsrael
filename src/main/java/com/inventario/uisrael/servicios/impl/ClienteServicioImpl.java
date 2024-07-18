package com.inventario.uisrael.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.Cliente;
import com.inventario.uisrael.repositorio.IClienteRepositorio;
import com.inventario.uisrael.servicios.IClienteServicio;
@Service

public class ClienteServicioImpl implements IClienteServicio {
	@Autowired
	IClienteRepositorio clienteRepositorio;
	@Override
	public Optional<Cliente> buscarClienteId(int idCliente) {
		try {
			return clienteRepositorio.findById(idCliente);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public boolean eliminarClienteId(int idCliente) {
		// TODO Auto-generated method stub
		try {
			 clienteRepositorio.deleteById(idCliente);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;

		}
	}

	@Override
	public List<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		try {
			return clienteRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
		
	}

	@Override
	public void insertarCliente(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
		
		try {
			clienteRepositorio.save(nuevoCliente);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarCliente(Cliente editarCliente) {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
