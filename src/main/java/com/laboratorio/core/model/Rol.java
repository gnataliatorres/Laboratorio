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
@Table(name = "rol")
public class Rol implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="codigo_rol")
	private Long codigoRol;
	@Column (name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy="codigoRol", cascade = CascadeType.ALL)
	private Set<Usuario> usuario =  new HashSet<Usuario>();

	
	
	public Rol() {
		
	}
	public Rol(Long codigoRol, String descripcion) {
		super();
		this.codigoRol = codigoRol;
		this.descripcion = descripcion;
	}
	
	
	
	public Set<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}
	public Long getCodigoRol() {
		return codigoRol;
	}
	public void setCodigoRol(Long codigoRol) {
		this.codigoRol = codigoRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoRol == null) ? 0 : codigoRol.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
		Rol other = (Rol) obj;
		if (codigoRol == null) {
			if (other.codigoRol != null)
				return false;
		} else if (!codigoRol.equals(other.codigoRol))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
	
	
}
