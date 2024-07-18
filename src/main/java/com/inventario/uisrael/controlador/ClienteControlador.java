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
import com.inventario.uisrael.servicios.IClienteServicio;

@Controller

public class ClienteControlador {
	@Autowired
	public IClienteServicio servicioCliente;
	//Listar
	@GetMapping("/listar_cliente") 
	public String listarCurso(Model model) {
		List<Cliente> listarCliente = servicioCliente.listarCliente();
		model.addAttribute("lista", listarCliente);
		return "cliente/listaCliente";//ruta fisica de pagina
	} 
	@GetMapping("/cliente_nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("nuevoCliente", new Cliente());

		return "cliente/cliente";//ruta fisica de pagina
	}
	@PostMapping("/insertar_cliente")
	public String guardarCliente(@ModelAttribute("nuevoCliente") Cliente nuevoCliente) {
		servicioCliente.insertarCliente(nuevoCliente);
		return "redirect:/listar_cliente";
		
	}
	@GetMapping("/editar_cliente/{idcliente}")
	public String editarCliente(@PathVariable(value="idcliente") int idCliente,Model model ){
		Optional<Cliente> ClienteRecuperado = servicioCliente.buscarClienteId(idCliente); 
		model.addAttribute("nuevoCliente", ClienteRecuperado);
		return "cliente/cliente";
	}
	@GetMapping("/eliminar_cliente/{idcliente}")
	public String eliminarCliente(@PathVariable(value="idcliente") int idCliente) {
		boolean clienteEliminado = servicioCliente.eliminarClienteId(idCliente);
		return "redirect:/listar_cliente";
		
	}
	
}
