package com.inventario.uisrael.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.uisrael.modelo.Cliente;


public interface IClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
