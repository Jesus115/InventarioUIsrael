package com.inventario.uisrael.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventario.uisrael.modelo.DetalleOrdenCompra;

public interface IDetalleOrdenCompraRepositorio extends JpaRepository<DetalleOrdenCompra, Integer> {
	@Query("SELECT doc FROM DetalleOrdenCompra doc where doc.ordenCompra.idOrdenCompra = :id")
	public List<DetalleOrdenCompra> traerTodosMisDetallesCompras(@Param("id")Integer id);
}
