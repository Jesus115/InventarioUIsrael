package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.DetalleOrdenCompra;

@Service
public interface IDetalleOrdenCompraServicio {
	public List<DetalleOrdenCompra> traerTodosMisDetallesCompras(int idOrdenCompra);
	public boolean eliminarDetalleOrdenId(int idDetalleOrdenCompra);
	public List<DetalleOrdenCompra> listarDetalleOrdenCompra();
	public void insertarDetalleOrdenCompra(DetalleOrdenCompra nuevoDetalleOrdenCompra);
	public void actualizarDetalleOrdenCompra(DetalleOrdenCompra editarDetalleOrdenCompra);
	public Optional<DetalleOrdenCompra> buscarDetalleOrdenCompraId(int idDetalleOrdenCompra);

}
