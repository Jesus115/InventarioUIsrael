package com.inventario.uisrael.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.DetalleOrdenVenta;
import com.inventario.uisrael.repositorio.IDetalleOrdenCompraRepositorio;
import com.inventario.uisrael.repositorio.IDetalleOrdenVentaRepositorio;
import com.inventario.uisrael.servicios.IDetalleOrdenVentaServicio;
@Service

public class DetalleOrdenVentaServicioImpl implements IDetalleOrdenVentaServicio {
	@Autowired
	IDetalleOrdenVentaRepositorio detalleVentaRepositorio;
	

	@Override
	public boolean eliminarDetalleOrdenVentaId(int idDetalleOrdenVenta) {
		try {
			detalleVentaRepositorio.deleteById(idDetalleOrdenVenta);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public void insertarDetalleOrdenVenta(DetalleOrdenVenta nuevoDetalleOrdenVenta) {
		// TODO Auto-generated method stub
		try {
			detalleVentaRepositorio.save(nuevoDetalleOrdenVenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarDetalleOrdenVenta(DetalleOrdenVenta editarDetalleOrdenVenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DetalleOrdenVenta> traerTodosMisDetallesVentas(int idOrdenVenta) {

		try {
			return detalleVentaRepositorio.traerTodosMisDetallesVentas(idOrdenVenta);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public Optional<DetalleOrdenVenta> buscarDetalleOrdenVentaId(int idDetalleOrdenventa) {
		try {
			return detalleVentaRepositorio.findById(idDetalleOrdenventa);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

}
