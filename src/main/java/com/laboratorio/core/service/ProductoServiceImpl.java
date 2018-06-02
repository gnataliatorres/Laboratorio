package com.laboratorio.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratorio.core.dao.ProductoDao;
import com.laboratorio.core.model.Producto;
@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private  ProductoDao productoServiceDao;
	
	@Override
	public void saveProducto(Producto elemento) {
		productoServiceDao.saveProducto(elemento);
		
	}

	@Override
	public void deleteProductoById(Long codigoProducto) {
		productoServiceDao.deleteProductoById(codigoProducto);
		
	}

	@Override
	public void updateProducto(Producto elemento) {
		productoServiceDao.updateProducto(elemento);
		
	}

	@Override
	public Producto findById(Long codigoProducto) {
		return productoServiceDao.findById(codigoProducto);
	}

	@Override
	public List<Producto> findAllProductos() {
		return productoServiceDao.findAllProductos();
	}

	@Override
	public Producto findByNombre(String nombre) {
		return productoServiceDao.findByNombre(nombre);
	}

}
