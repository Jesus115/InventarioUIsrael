package com.inventario.uisrael.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventario.uisrael.modelo.Producto;
import com.inventario.uisrael.modelo.Proveedor;

@Service
public interface IProveedorServicio {
	public Optional<Proveedor> buscarProveedorId(int idProveedor);
	public boolean eliminarProveedorId(int idProveedor);
	public List<Proveedor> listarProveedor();
	public void insertarProveedor(Proveedor nuevoProveedor);
	public void actualizarProveedor(Proveedor editarProveedor);
}
