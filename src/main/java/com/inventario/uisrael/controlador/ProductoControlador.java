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

import com.inventario.uisrael.modelo.Cliente;
import com.inventario.uisrael.modelo.Producto;
import com.inventario.uisrael.servicios.IProductoServicio;

@Controller

public class ProductoControlador {
	@Autowired
	public IProductoServicio servicioProducto;
	//Listar
	@GetMapping("/listar_producto") 
	public String listarProducto(Model model) {
		List<Producto> listarProducto = servicioProducto.listarProducto();
		model.addAttribute("lista", listarProducto);
		return "producto/listaProducto";//ruta fisica de pagina
	} 
    @GetMapping("/producto_nuevo")
	public String nuevoProducto(Model model) {
		model.addAttribute("nuevoProducto", new Producto());

		return "producto/producto";//ruta fisica de pagina
	}
    @PostMapping("/insertar_producto")
	public String guardarProducto(@ModelAttribute("nuevoProducto") Producto nuevoProducto) {
		servicioProducto.insertarProducto(nuevoProducto);
		return "redirect:/listar_producto";
		
	}
	@GetMapping("/editar_producto/{idProducto}")
	public String editarProducto(@PathVariable(value="idProducto") int idProducto,Model model ){
		Optional<Producto> ProductoRecuperado = servicioProducto.buscarProductoId(idProducto); 
		model.addAttribute("nuevoProducto", ProductoRecuperado);
		return "producto/producto";
	}
	@GetMapping("/eliminar_producto/{idProducto}")
	public String eliminarProducto(@PathVariable(value="idProducto") int idProducto) {
		boolean ProductoEliminado = servicioProducto.eliminarProductoId(idProducto);
		return "redirect:/listar_producto";
		
	}
}
