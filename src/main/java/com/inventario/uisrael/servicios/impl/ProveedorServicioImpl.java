package com.inventario.uisrael.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.Producto;
import com.inventario.uisrael.modelo.Proveedor;
import com.inventario.uisrael.repositorio.IProductoRepositorio;
import com.inventario.uisrael.repositorio.IProveedorRepositorio;
import com.inventario.uisrael.servicios.IProveedorServicio;
@Service

public class ProveedorServicioImpl implements IProveedorServicio{
	@Autowired
	IProveedorRepositorio proveedorRepositorio;
	@Override
	public Optional<Proveedor> buscarProveedorId(int idProveedor) {
		try {
			return proveedorRepositorio.findById(idProveedor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public boolean eliminarProveedorId(int idProveedor) {
		// TODO Auto-generated method stub
		try {
			proveedorRepositorio.deleteById(idProveedor);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return false;
		}
	}

	@Override
	public List<Proveedor> listarProveedor() {
		// TODO Auto-generated method stub
		try {
			return proveedorRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return null;

		}
	}

	@Override
	public void insertarProveedor(Proveedor nuevoProveedor) {
		// TODO Auto-generated method stub
		try {
			proveedorRepositorio.save(nuevoProveedor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
		
	}

	@Override
	public void actualizarProveedor(Proveedor editarProveedor) {
		// TODO Auto-generated method stub
		
	}
	
}
