package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.DetalleOrdenCompra;
import com.inventario.uisrael.modelo.DetalleOrdenVenta;

@Service
public interface IDetalleOrdenVentaServicio {
	public boolean eliminarDetalleOrdenVentaId(int idDetalleOrdenVenta);
	public void insertarDetalleOrdenVenta(DetalleOrdenVenta nuevoDetalleOrdenVenta);
	public void actualizarDetalleOrdenVenta(DetalleOrdenVenta editarDetalleOrdenVenta);
	public List<DetalleOrdenVenta> traerTodosMisDetallesVentas(int idOrdenVenta);
	public Optional<DetalleOrdenVenta> buscarDetalleOrdenVentaId(int idDetalleOrdenventa);

}
