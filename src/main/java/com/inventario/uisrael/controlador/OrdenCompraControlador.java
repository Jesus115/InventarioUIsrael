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

import com.inventario.uisrael.modelo.DetalleOrdenCompra;
import com.inventario.uisrael.modelo.OrdenCompra;
import com.inventario.uisrael.modelo.Producto;
import com.inventario.uisrael.modelo.Proveedor;
import com.inventario.uisrael.servicios.IDetalleOrdenCompraServicio;
import com.inventario.uisrael.servicios.IOrdenCompraServicio;
import com.inventario.uisrael.servicios.IProductoServicio;
import com.inventario.uisrael.servicios.IProveedorServicio;

@Controller

public class OrdenCompraControlador {
	@Autowired
	public IOrdenCompraServicio ocServicio;
	@Autowired
	public IProveedorServicio servicioProveedor;
	@Autowired
	public IProductoServicio servicioProducto;
	@Autowired
	public IDetalleOrdenCompraServicio docServicio;
	//Listar
	@GetMapping("/listar_orden_compra") 
	public String listarOC(Model model) {
		List<OrdenCompra> listaroc = ocServicio.listarOrdenCompra();

		model.addAttribute("lista", listaroc);
		return "ordenCompra/listaordenCompra";//ruta fisica de pagina
	} 
	@GetMapping("/orden_compra_nuevo")
	public String nuevoCliente(Model model) {
		List<Proveedor> listarProveedor = servicioProveedor.listarProveedor();
		model.addAttribute("listarProveedor", listarProveedor);
		model.addAttribute("nuevoOrdenCompra", new OrdenCompra());

		return "ordenCompra/ordenCompra";//ruta fisica de pagina
	}
	@GetMapping("/detalle_orden_compra_nuevo/{idOrdenCompra}")
	public String nuevoDetalleOrdenCompra(@PathVariable(value="idOrdenCompra") int idOrdenCompra,Model model) {
		
		List<Producto> listarProducto = servicioProducto.listarProducto();
		Optional<OrdenCompra> ordenCompraRecuperado = ocServicio.buscarOrdenCompraId(idOrdenCompra); 
		OrdenCompra ordenCompra = ordenCompraRecuperado.orElse(new OrdenCompra());
		List<Proveedor> listarProveedor = servicioProveedor.listarProveedor();
		DetalleOrdenCompra nuevoDetalleOrdenCompra = new DetalleOrdenCompra();
	    nuevoDetalleOrdenCompra.setOrdenCompra(ordenCompra); // Establece la relación con OrdenCompra

		model.addAttribute("listarProveedor", listarProveedor);
		model.addAttribute("nuevoOrdenCompra", ordenCompra);
		model.addAttribute("listarProducto", listarProducto);
		model.addAttribute("nuevoDetalleOrdenCompra", nuevoDetalleOrdenCompra);

		return "ordenCompra/detalleOrdenCompra";//ruta fisica de pagina
	}
	@GetMapping("/editar_detalle_orden_compra/{idDetalleOrdenCompra}/{idOrdenCompra}")
	public String editarDetalleOrdenCompra(@PathVariable("idDetalleOrdenCompra") int idDetalleOrdenCompra,
											@PathVariable("idOrdenCompra") int idOrdenCompra,Model model) {
		
		List<Producto> listarProducto = servicioProducto.listarProducto();
		Optional<OrdenCompra> ordenCompraRecuperado = ocServicio.buscarOrdenCompraId(idOrdenCompra); 
		OrdenCompra ordenCompra = ordenCompraRecuperado.orElse(new OrdenCompra());
		List<Proveedor> listarProveedor = servicioProveedor.listarProveedor();
		Optional<DetalleOrdenCompra> nuevoDetalleOrdenCompra = docServicio.buscarDetalleOrdenCompraId(idDetalleOrdenCompra);

		model.addAttribute("listarProveedor", listarProveedor);
		model.addAttribute("nuevoOrdenCompra", ordenCompra);
		model.addAttribute("listarProducto", listarProducto);
		model.addAttribute("nuevoDetalleOrdenCompra", nuevoDetalleOrdenCompra);

		return "ordenCompra/detalleOrdenCompra";//ruta fisica de pagina
	}
	
	@PostMapping("/insertar_detalle_orden_compra")
	public String guardarDetalleOrdenCompra(@ModelAttribute("nuevoDetalleOrdenCompra") DetalleOrdenCompra nuevoDetalleOrdenCompra) {
		docServicio.insertarDetalleOrdenCompra(nuevoDetalleOrdenCompra);
		return "redirect:/editar_orden_compra/"+nuevoDetalleOrdenCompra.getOrdenCompra().getIdOrdenCompra();
		
	}
	
	@PostMapping("/insertar_orden_compra")
	public String guardarOrdenCompra(@ModelAttribute("nuevoOrdenCompra") OrdenCompra nuevoOrdenCompra) {
		ocServicio.insertarOrdenCompra(nuevoOrdenCompra);
		return "redirect:/listar_orden_compra";
		
	}
	@GetMapping("/editar_orden_compra/{idOrdenCompra}")
	public String editarOrdenCompra(@PathVariable(value="idOrdenCompra") int idOrdenCompra,Model model ){
		// List<Proveedor> listarProveedor = servicioProveedor.listarProveedor();
		// Optional<OrdenCompra> OrdenCompraRecuperado = ocServicio.buscarOrdenCompraId(idOrdenCompra); 
		// model.addAttribute("listarProveedor", listarProveedor);
		// model.addAttribute("nuevoOrdenCompra", OrdenCompraRecuperado);
		List<Proveedor> listarProveedor = servicioProveedor.listarProveedor();
		Optional<OrdenCompra> ordenCompraRecuperado = ocServicio.buscarOrdenCompraId(idOrdenCompra); 

		// Desempaquetar el Optional
		OrdenCompra ordenCompra = ordenCompraRecuperado.orElse(new OrdenCompra());
		List<DetalleOrdenCompra> detalle = docServicio.traerTodosMisDetallesCompras(idOrdenCompra);
		model.addAttribute("detalle", detalle);
		model.addAttribute("listarProveedor", listarProveedor);
		model.addAttribute("nuevoOrdenCompra", ordenCompra);
		return "ordenCompra/ordenCompra";
	}
	@GetMapping("/eliminar_orden_compra/{idOrdenCompra}")
	public String eliminarOrdenCompra(@PathVariable(value="idOrdenCompra") int idOrdenCompra) {
		boolean OrdenCompraEliminado = ocServicio.eliminarOrdenCompraId(idOrdenCompra);
		return "redirect:/listar_orden_compra";
		
	}
	@GetMapping("/eliminar_detalle_orden_compra/{idDetalleOrdenCompra}")
	public String eliminarDetalleOrdenCompra(@PathVariable(value="idDetalleOrdenCompra") int idDetalleOrdenCompra) {
		boolean DetalleOrdenCompraEliminado = docServicio.eliminarDetalleOrdenId(idDetalleOrdenCompra);
		return "redirect:/listar_orden_compra";
		
	}
	
}
