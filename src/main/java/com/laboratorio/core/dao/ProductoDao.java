package com.laboratorio.core.dao;

import java.util.List;

import com.laboratorio.core.model.Producto;

public interface ProductoDao {

	void saveProducto(Producto elemento);
	void deleteProductoById(Long codigoProducto);
	void updateProducto(Producto elemento);
	Producto findById(Long codigoProducto);
	List<Producto> findAllProductos();
    Producto findByNombre(String nombre);
}
