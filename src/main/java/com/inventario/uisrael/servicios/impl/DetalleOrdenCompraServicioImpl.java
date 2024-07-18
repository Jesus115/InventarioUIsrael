package com.inventario.uisrael.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.DetalleOrdenCompra;
import com.inventario.uisrael.repositorio.IDetalleOrdenCompraRepositorio;
import com.inventario.uisrael.servicios.IDetalleOrdenCompraServicio;
@Service

public class DetalleOrdenCompraServicioImpl implements IDetalleOrdenCompraServicio{
	@Autowired
	IDetalleOrdenCompraRepositorio detalleCompraRepositorio;
	@Override
	public List<DetalleOrdenCompra> traerTodosMisDetallesCompras(int idOrdenCompra) {
		try {
			return detalleCompraRepositorio.traerTodosMisDetallesCompras(idOrdenCompra);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public boolean eliminarDetalleOrdenId(int idOrdenCompra) {
		try {
			detalleCompraRepositorio.deleteById(idOrdenCompra);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;

		}
	}

	@Override
	public List<DetalleOrdenCompra> listarDetalleOrdenCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarDetalleOrdenCompra(DetalleOrdenCompra nuevoDetalleOrdenCompra) {
		
		try {
			 detalleCompraRepositorio.save(nuevoDetalleOrdenCompra);
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void actualizarDetalleOrdenCompra(DetalleOrdenCompra editarDetalleOrdenCompra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<DetalleOrdenCompra> buscarDetalleOrdenCompraId(int idDetalleOrdenCompra) {
		try {
			return detalleCompraRepositorio.findById(idDetalleOrdenCompra);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}
	
}
