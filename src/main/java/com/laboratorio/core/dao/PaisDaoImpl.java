package com.laboratorio.core.dao;

import java.util.List;

import com.laboratorio.core.model.Pais;
import com.laboratorio.core.model.Producto;


public class PaisDaoImpl extends AbstractSession implements PaisDao{

	@Override
	public void savePais(Pais elemento) {
		getSession().persist(elemento);
	}

	@Override
	public void deletePaisById(Long codigoPais) {
		Pais elemento = findById(codigoPais);
		if (elemento != null) {
			getSession().delete(elemento);
		}
		
	}

	@Override
	public void updatePais(Pais elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public Pais findById(Long codigoPais) {
		return (Pais)getSession().get(Pais.class, codigoPais);
	}

	@Override
	public List<Pais> findAllProductos() {
		return getSession().createQuery("from Pais").list();
	}

	@Override
	public Pais findByNombre(String nombre) {
		return (Pais)getSession().createQuery("from Pais where nombre = :nombre").setParameter("nombre", nombre).uniqueResult();
	}

}
