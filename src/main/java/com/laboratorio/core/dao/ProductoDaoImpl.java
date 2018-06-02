package com.laboratorio.core.dao;

import java.util.List;

import com.laboratorio.core.dao.AbstractSession;
import com.laboratorio.core.dao.ProductoDao;
import com.laboratorio.core.model.Producto;

public class ProductoDaoImpl extends AbstractSession implements ProductoDao{

	@Override
	public void saveProducto(Producto elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deleteProductoById(Long codigoProducto) {
		Producto elemento = findById(codigoProducto);
		if (elemento != null) {
			getSession().delete(elemento);
		}
		
	}

	@Override
	public void updateProducto(Producto elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public Producto findById(Long codigoProducto) {
		return (Producto)getSession().get(Producto.class, codigoProducto);
	}

	@Override
	public List<Producto> findAllProductos() {
		return getSession().createQuery("from Producto").list();
	}

	@Override
	public Producto findByNombre(String nombre) {
		return (Producto)getSession().createQuery("from Producto where nombre = :nombre").setParameter("nombre", nombre).uniqueResult();
	}

}
