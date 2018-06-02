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
@Table(name = "tipo_instrumento")
public class TipoInstrumento implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="codigo_instrumento")
	private Long codigoInstrumento;
	@Column (name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy="codigoInstrumento", cascade = CascadeType.ALL)
	private Set<Producto> producto = new HashSet<Producto>();
	
	
	public TipoInstrumento() {
		
	}
	public TipoInstrumento(Long codigoInstrumento, String descripcion) {
		super();
		this.codigoInstrumento = codigoInstrumento;
		this.descripcion = descripcion;
	}
	public Long getCodigoInstrumento() {
		return codigoInstrumento;
	}
	public void setCodigoInstrumento(Long codigoInstrumento) {
		this.codigoInstrumento = codigoInstrumento;
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
		result = prime * result + ((codigoInstrumento == null) ? 0 : codigoInstrumento.hashCode());
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
		TipoInstrumento other = (TipoInstrumento) obj;
		if (codigoInstrumento == null) {
			if (other.codigoInstrumento != null)
				return false;
		} else if (!codigoInstrumento.equals(other.codigoInstrumento))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
	
	

}
