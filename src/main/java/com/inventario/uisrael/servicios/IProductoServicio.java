package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.OrdenVenta;
import com.inventario.uisrael.modelo.Producto;

@Service
public interface IProductoServicio {
	public Optional<Producto> buscarProductoId(int idProducto);
	public boolean eliminarProductoId(int idProducto);
	public List<Producto> listarProducto();
	public void insertarProducto(Producto nuevoProducto);
	public void actualizarProducto(Producto editarProducto);
}
