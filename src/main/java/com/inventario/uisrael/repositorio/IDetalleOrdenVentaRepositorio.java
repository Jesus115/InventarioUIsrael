package com.inventario.uisrael.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventario.uisrael.modelo.DetalleOrdenVenta;

public interface IDetalleOrdenVentaRepositorio extends JpaRepository<DetalleOrdenVenta, Integer> {
	@Query("SELECT dov FROM DetalleOrdenVenta dov where dov.ordenVenta.idOrdenVenta = :id")

	public List<DetalleOrdenVenta> traerTodosMisDetallesVentas(@Param("id")Integer id);
}
