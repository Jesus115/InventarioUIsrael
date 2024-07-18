package com.inventario.uisrael.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.OrdenCompra;
import com.inventario.uisrael.modelo.OrdenVenta;
import com.inventario.uisrael.repositorio.IDetalleOrdenVentaRepositorio;
import com.inventario.uisrael.repositorio.IOrdenVentaRepositorio;
import com.inventario.uisrael.servicios.IOrdenVentaServicio;
@Service

public class OrdenVentaServicioImpl implements IOrdenVentaServicio{
	@Autowired
	IOrdenVentaRepositorio ordenVentaRepositorio;
	@Override
	public Optional<OrdenVenta>  buscarOrdenVentaId(int idOrdenVenta) {
		// TODO Auto-generated method stub
		return ordenVentaRepositorio.findById(idOrdenVenta);
	}

	@Override
	public boolean eliminarOrdenVentaId(int idOrdenVenta) {
		// TODO Auto-generated method stub
		try {
			ordenVentaRepositorio.deleteById(idOrdenVenta);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return false;
		}
	}

	@Override
	public List<OrdenVenta> listarOrdenVenta() {
		// TODO Auto-generated method stub
		try {
			return ordenVentaRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return null;

		}
	}

	@Override
	public void insertarOrdenVenta(OrdenVenta nuevoOrdenVenta) {
		// TODO Auto-generated method stub
		try {
			ordenVentaRepositorio.save(nuevoOrdenVenta);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void actualizarOrdenVenta(OrdenVenta editarOrdenVenta) {
		// TODO Auto-generated method stub
		
	}

}
