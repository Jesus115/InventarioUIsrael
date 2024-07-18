package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.OrdenCompra;
import com.inventario.uisrael.modelo.OrdenVenta;

@Service
public interface IOrdenVentaServicio {
	public Optional<OrdenVenta>  buscarOrdenVentaId(int idOrdenVenta);
	public boolean eliminarOrdenVentaId(int idOrdenVenta);
	public List<OrdenVenta> listarOrdenVenta();
	public void insertarOrdenVenta(OrdenVenta nuevoOrdenVenta);
	public void actualizarOrdenVenta(OrdenVenta editarOrdenVenta);
}
