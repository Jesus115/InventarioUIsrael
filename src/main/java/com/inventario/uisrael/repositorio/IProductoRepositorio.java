package com.inventario.uisrael.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.uisrael.modelo.Producto;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer>{

}
