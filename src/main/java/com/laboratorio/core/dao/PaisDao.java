package com.laboratorio.core.dao;

import java.util.List;

import com.laboratorio.core.model.Pais;

public interface PaisDao {
	void savePais(Pais elemento);
	void deletePaisById(Long codigoPais);
	void updatePais(Pais elemento);
	Pais findById(Long codigoPais);
	List<Pais> findAllProductos();
    Pais findByNombre(String nombre);

}
