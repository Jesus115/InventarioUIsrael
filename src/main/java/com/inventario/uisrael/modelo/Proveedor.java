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
public class Proveedor implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idProveedor;
	private String  nombre;
	private String  cedula;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  fechaRegistro;
	private boolean  estado;
}
