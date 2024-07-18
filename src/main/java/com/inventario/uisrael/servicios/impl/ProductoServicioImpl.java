package com.inventario.uisrael.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.Producto;
import com.inventario.uisrael.repositorio.IProductoRepositorio;
import com.inventario.uisrael.servicios.IProductoServicio;
@Service

public class ProductoServicioImpl implements IProductoServicio {
	@Autowired
	IProductoRepositorio productoRepositorio;
	@Override
	public java.util.Optional<Producto> buscarProductoId(int idProducto) {
		// TODO Auto-generated method stub
		return productoRepositorio.findById(idProducto);
	}

	@Override
	public boolean eliminarProductoId(int idProducto) {
		// TODO Auto-generated method stub
		try {
			productoRepositorio.deleteById(idProducto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return false;

		}
	}

	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		try {
			return productoRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return null;

		}
	}

	@Override
	public void insertarProducto(Producto nuevoProducto) {
		// TODO Auto-generated method stub
		try {
			productoRepositorio.save(nuevoProducto);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void actualizarProducto(Producto editarProducto) {
		// TODO Auto-generated method stub
		
	}

}
