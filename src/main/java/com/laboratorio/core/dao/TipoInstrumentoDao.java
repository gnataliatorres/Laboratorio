package com.laboratorio.core.dao;

import java.util.List;

import com.laboratorio.core.model.TipoInstrumento;

public interface TipoInstrumentoDao {
	
	void saveTipoInstrumento(TipoInstrumento elemento);
	void deleteTipoInstrumentoById(Long codigoTipoInstrumento);
	void updateProducto(TipoInstrumento elemento);
	TipoInstrumento findById(Long codigoTipoInstrumento);
	List<TipoInstrumento> findAllInstrumentos();
	TipoInstrumento findByNombre(String nombre);

}
