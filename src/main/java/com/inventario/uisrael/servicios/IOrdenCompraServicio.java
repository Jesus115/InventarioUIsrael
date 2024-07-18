package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.OrdenCompra;

@Service
public interface IOrdenCompraServicio {
	public Optional<OrdenCompra> buscarOrdenCompraId(int idOrdenCompra);
	public boolean eliminarOrdenCompraId(int idOrdenCompra);
	public List<OrdenCompra> listarOrdenCompra();
	public void insertarOrdenCompra(OrdenCompra nuevoOrdenCompra);
	public void actualizarOrdenCompra(OrdenCompra editarOrdenCompra);
}
