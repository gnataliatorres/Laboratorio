package com.laboratorio.core.service;

import java.util.List;

import com.laboratorio.core.model.Producto;

public interface ProductoService {

	void saveProducto(Producto elemento);
	void deleteProductoById(Long codigoProducto);
	void updateProducto(Producto elemento);
	Producto findById(Long codigoProducto);
	List<Producto> findAllProductos();
    Producto findByNombre(String nombre);
}
