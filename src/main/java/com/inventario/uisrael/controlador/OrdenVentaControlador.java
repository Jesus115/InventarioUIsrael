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
import com.inventario.uisrael.modelo.DetalleOrdenCompra;
import com.inventario.uisrael.modelo.DetalleOrdenVenta;
import com.inventario.uisrael.modelo.OrdenCompra;
import com.inventario.uisrael.modelo.OrdenVenta;
import com.inventario.uisrael.modelo.Producto;
import com.inventario.uisrael.modelo.Proveedor;
import com.inventario.uisrael.servicios.IClienteServicio;
import com.inventario.uisrael.servicios.IDetalleOrdenVentaServicio;
import com.inventario.uisrael.servicios.IOrdenVentaServicio;
import com.inventario.uisrael.servicios.IProductoServicio;

@Controller

public class OrdenVentaControlador {
    @Autowired
    IOrdenVentaServicio ventasServicio;
    @Autowired
	public IClienteServicio servicioCliente;
    @Autowired
	public IProductoServicio servicioProducto;

    @Autowired
	public IDetalleOrdenVentaServicio detServicioVentas;

    @GetMapping("/listar_orden_venta") 
	public String listarVentas(Model model) {
		List<OrdenVenta> listarVentas = ventasServicio.listarOrdenVenta();

		model.addAttribute("lista", listarVentas);
		return "ordenVenta/listaOrdenVenta";//ruta fisica de pagina
	} 
    @GetMapping("/orden_venta_nuevo")
	public String nuevaVenta(Model model) {
		List<Cliente> listarCliente = servicioCliente.listarCliente();
		model.addAttribute("listarClientes", listarCliente);
		model.addAttribute("nuevoOrdenVenta", new OrdenVenta());

		return "ordenVenta/ordenVenta";//ruta fisica de pagina
	}
    @GetMapping("/detalle_orden_venta_nuevo/{idOrdenVenta}")
	public String nuevoDetalleOrdenVenta(@PathVariable(value="idOrdenVenta") int idOrdenVenta,Model model) {
		
		List<Producto> listarProducto = servicioProducto.listarProducto();
		Optional<OrdenVenta> ordenVentaRecuperado = ventasServicio.buscarOrdenVentaId(idOrdenVenta); 
		OrdenVenta ordenVenta = ordenVentaRecuperado.orElse(new OrdenVenta());
		List<Cliente> listarClientes = servicioCliente.listarCliente();
		DetalleOrdenVenta nuevoDetalleOrdenVenta = new DetalleOrdenVenta();
	    nuevoDetalleOrdenVenta.setOrdenVenta(ordenVenta); // Establece la relación con OrdenCompra

		model.addAttribute("listarClientes", listarClientes);
		model.addAttribute("nuevoOrdenVenta", ordenVenta);
		model.addAttribute("listarProducto", listarProducto);
		model.addAttribute("nuevoDetalleOrdenVenta", nuevoDetalleOrdenVenta);

		return "ordenVenta/detalleOrdenVenta";//ruta fisica de pagina
	}
    @GetMapping("/editar_detalle_orden_venta/{idDetalleOrdenVenta}/{idOrdenVenta}")
	public String editarDetalleOrdenVenta(@PathVariable("idDetalleOrdenVenta") int idDetalleOrdenVenta,
											@PathVariable("idOrdenVenta") int idOrdenVenta,Model model) {
		
		List<Producto> listarProducto = servicioProducto.listarProducto();
		Optional<OrdenVenta> ordenVentaRecuperado = ventasServicio.buscarOrdenVentaId(idOrdenVenta); 
		OrdenVenta ordenVenta = ordenVentaRecuperado.orElse(new OrdenVenta());
		List<Cliente> listarClientes = servicioCliente.listarCliente();
		Optional<DetalleOrdenVenta> nuevoDetalleOrdenVenta = detServicioVentas.buscarDetalleOrdenVentaId(idDetalleOrdenVenta);

		model.addAttribute("listarClientes", listarClientes);
		model.addAttribute("ordenVenta", ordenVenta);
		model.addAttribute("listarProducto", listarProducto);
		model.addAttribute("nuevoDetalleOrdenVenta", nuevoDetalleOrdenVenta);

		return "ordenVenta/detalleOrdenventa";//ruta fisica de pagina
	}
    @PostMapping("/insertar_detalle_orden_venta")
	public String guardarDetalleOrdenventa(@ModelAttribute("nuevoDetalleOrdenventa") DetalleOrdenVenta nuevoDetalleOrdenventa) {
		detServicioVentas.insertarDetalleOrdenVenta(nuevoDetalleOrdenventa);
		return "redirect:/editar_orden_venta/"+nuevoDetalleOrdenventa.getOrdenVenta().getIdOrdenVenta();
		
	}
    @PostMapping("/insertar_orden_venta")
	public String guardarOrdenVenta(@ModelAttribute("nuevoOrdenVenta") OrdenVenta nuevoOrdenVenta) {
		ventasServicio.insertarOrdenVenta(nuevoOrdenVenta);
		return "redirect:/listar_orden_venta";
		
	}
    @GetMapping("/editar_orden_venta/{idOrdenVenta}")
	public String editarOrdenventa(@PathVariable(value="idOrdenVenta") int idOrdenVenta,Model model ){
		
		List<Cliente> listarClientes = servicioCliente.listarCliente();
		Optional<OrdenVenta> ordenVentaRecuperado = ventasServicio.buscarOrdenVentaId(idOrdenVenta); 

		// Desempaquetar el Optional
		OrdenVenta ordenVenta = ordenVentaRecuperado.orElse(new OrdenVenta());
		List<DetalleOrdenVenta> detalle = detServicioVentas.traerTodosMisDetallesVentas(idOrdenVenta);
		model.addAttribute("detalle", detalle);
		model.addAttribute("listarClientes", listarClientes);
		model.addAttribute("nuevoOrdenVenta", ordenVenta);
		return "ordenVenta/ordenVenta";
	}
    @GetMapping("/eliminar_orden_venta/{idOrdenVenta}")
	public String eliminarOrdenVenta(@PathVariable(value="idOrdenVenta") int idOrdenVenta) {
		boolean OrdenVentaEliminado = ventasServicio.eliminarOrdenVentaId(idOrdenVenta);
		return "redirect:/listar_orden_venta";
		
	}
	@GetMapping("/eliminar_detalle_orden_venta/{idDetalleOrdenVenta}")
	public String eliminarDetalleOrdenCompra(@PathVariable(value="idDetalleOrdenVenta") int idDetalleOrdenVenta) {
		boolean DetalleOrdenCompraEliminado = detServicioVentas.eliminarDetalleOrdenVentaId(idDetalleOrdenVenta);
		return "redirect:/listar_orden_venta";
		
	}
	
}
