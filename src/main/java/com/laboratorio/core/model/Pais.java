package com.laboratorio.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="codigo_pais")
	private Long codigoPais;
	@Column (name="nombre")
	private String nombre;	
	@OneToMany(mappedBy="codigoPais", cascade = CascadeType.ALL)
	private Set<Producto> producto = new HashSet<Producto>();
	
	public Pais() {
		
	}

	public Pais(Long codigoPais, String nombre) {
		super();
		this.codigoPais = codigoPais;
		this.nombre = nombre;
	}

	
	
	public Set<Producto> getProducto() {
		return producto;
	}

	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}

	public Long getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPais == null) ? 0 : codigoPais.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (codigoPais == null) {
			if (other.codigoPais != null)
				return false;
		} else if (!codigoPais.equals(other.codigoPais))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
}
