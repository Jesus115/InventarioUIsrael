package com.inventario.uisrael.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.OrdenCompra;

import com.inventario.uisrael.repositorio.IOrdenCompraRepositorio;
import com.inventario.uisrael.repositorio.IProveedorRepositorio;
import com.inventario.uisrael.servicios.IOrdenCompraServicio;
@Service

public class OrdenCompraServicioImpl implements IOrdenCompraServicio{
	@Autowired
	IOrdenCompraRepositorio ordenCompraRepositorio;
	@Autowired
	IProveedorRepositorio proveedorRepositorio;
	
	@Override
	public Optional<OrdenCompra> buscarOrdenCompraId(int idOrdenCompra) {
		// TODO Auto-generated method stub
		return ordenCompraRepositorio.findById(idOrdenCompra);
	}

	@Override
	public boolean eliminarOrdenCompraId(int idOrdenCompra) {
		try {
			ordenCompraRepositorio.deleteById(idOrdenCompra);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return false;
		}
	}

	@Override
	public List<OrdenCompra> listarOrdenCompra() {
		// TODO Auto-generated method stub
		try {
			return ordenCompraRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return null;
		}
	}

	@Override
	public void insertarOrdenCompra(OrdenCompra nuevoOrdenCompra) {
		// TODO Auto-generated method stub
		try {
			ordenCompraRepositorio.save(nuevoOrdenCompra);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			
		}
	}

	@Override
	public void actualizarOrdenCompra(OrdenCompra editarOrdenCompra) {
		// TODO Auto-generated method stub
		
	}

}
