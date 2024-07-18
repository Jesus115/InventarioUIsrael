package com.inventario.uisrael.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class OrdenVenta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdenVenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaVenta;

    private Double total;

    private boolean estado;

    @OneToMany(mappedBy = "ordenVenta")
    private List<DetalleOrdenVenta> detalleOrdenVentas = new ArrayList<>();
}
