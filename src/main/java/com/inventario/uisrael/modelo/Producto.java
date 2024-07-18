package com.inventario.uisrael.modelo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idProducto;
	private String  nombre;
	private String  descripcion;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  fechaRegistro;
	private boolean  estado;
}
