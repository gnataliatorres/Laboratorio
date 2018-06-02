package com.laboratorio.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="codigo_producto")
	private Long codigoProducto;
	@Column (name="nombre")
	private String nombre;
	@Column (name="modelo")
	private String modelo;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn (name = "codigo_instrumento", referencedColumnName="codigo_instrumento", nullable = false, insertable = false, updatable = false)
	private TipoInstrumento  codigoInstrumento;
	@Column (name="precio")
	private float precio;
	@Column (name="garantia_meses")
	private Integer garantiaMeses;
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn (name = "codigo_pais", referencedColumnName="codigo_pais", nullable = false, insertable = false, updatable = false)
	private Pais codigoPais;
	public Producto(Long codigoProducto, String nombre, String modelo, TipoInstrumento codigoInstrumento, float precio,
			Integer garantiaMeses, Pais codigoPais) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.modelo = modelo;
		this.codigoInstrumento = codigoInstrumento;
		this.precio = precio;
		this.garantiaMeses = garantiaMeses;
		this.codigoPais = codigoPais;
	}
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public TipoInstrumento getCodigoInstrumento() {
		return codigoInstrumento;
	}
	public void setCodigoInstrumento(TipoInstrumento codigoInstrumento) {
		this.codigoInstrumento = codigoInstrumento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Integer getGarantiaMeses() {
		return garantiaMeses;
	}
	public void setGarantiaMeses(Integer garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}
	public Pais getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(Pais codigoPais) {
		this.codigoPais = codigoPais;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProducto == null) ? 0 : codigoProducto.hashCode());
		result = prime * result + ((garantiaMeses == null) ? 0 : garantiaMeses.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
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
		Producto other = (Producto) obj;
		if (codigoProducto == null) {
			if (other.codigoProducto != null)
				return false;
		} else if (!codigoProducto.equals(other.codigoProducto))
			return false;
		if (garantiaMeses == null) {
			if (other.garantiaMeses != null)
				return false;
		} else if (!garantiaMeses.equals(other.garantiaMeses))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}
	
	
}
