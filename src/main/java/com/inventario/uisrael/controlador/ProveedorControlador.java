package com.inventario.uisrael.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.inventario.uisrael.modelo.Proveedor;
import com.inventario.uisrael.servicios.IProveedorServicio;

@Controller

public class ProveedorControlador {
	@Autowired
	public IProveedorServicio servicioProveedor;
	//Listar
	@GetMapping("/listar_proveedor") 
	public String listarProveedor(Model model) {
		List<Proveedor> listarProveedor = servicioProveedor.listarProveedor();
		model.addAttribute("lista", listarProveedor);
		return "proveedor/listaProveedor";//ruta fisica de pagina
	} 
	@GetMapping("/proveedor_nuevo")
	public String nuevoProveedor(Model model) {
		model.addAttribute("nuevoProveedor", new Proveedor());

		return "proveedor/proveedor";//ruta fisica de pagina
	}
	@PostMapping("/insertar_proveedor")
	public String guardarProveedor(@ModelAttribute("nuevoProveedor") Proveedor nuevoProveedor) {
		servicioProveedor.insertarProveedor(nuevoProveedor);
		return "redirect:/listar_proveedor";
		
	}
	@GetMapping("/editar_proveedor/{idProveedor}")
	public String editarProveedor(@PathVariable(value="idProveedor") int idProveedor,Model model ){
		Optional<Proveedor> ProveedorRecuperado = servicioProveedor.buscarProveedorId(idProveedor); 
		model.addAttribute("nuevoProveedor", ProveedorRecuperado);
		return "proveedor/proveedor";
	}
	@GetMapping("/eliminar_proveedor/{idProveedor}")
	public String eliminarProveedor(@PathVariable(value="idProveedor") int idProveedor) {
		boolean ProveedorEliminado = servicioProveedor.eliminarProveedorId(idProveedor);
		return "redirect:/listar_proveedor";
		
	}
}
