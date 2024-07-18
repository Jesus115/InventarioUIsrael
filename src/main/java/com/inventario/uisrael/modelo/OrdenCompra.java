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
public class OrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenCompra;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    private boolean estado;

    @OneToMany(mappedBy = "ordenCompra")
    private List<DetalleOrdenCompra> detalleOrdenCompras = new ArrayList<>();
}
