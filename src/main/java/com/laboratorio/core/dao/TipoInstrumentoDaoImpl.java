package com.laboratorio.core.dao;

import java.util.List;

import com.laboratorio.core.model.Producto;
import com.laboratorio.core.model.TipoInstrumento;

public class TipoInstrumentoDaoImpl extends AbstractSession implements TipoInstrumentoDao{

	@Override
	public void saveTipoInstrumento(TipoInstrumento elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deleteTipoInstrumentoById(Long codigoTipoInstrumento) {
		TipoInstrumento elemento = findById(codigoTipoInstrumento);
		if (elemento != null) {
			getSession().delete(elemento);
		}
		
		
	}

	@Override
	public void updateProducto(TipoInstrumento elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public TipoInstrumento findById(Long codigoTipoInstrumento) {
		return (TipoInstrumento)getSession().get(TipoInstrumento.class, codigoTipoInstrumento);
	}

	@Override
	public List<TipoInstrumento> findAllInstrumentos() {
		return getSession().createQuery("from TipoInstrumento").list();
	}

	@Override
	public TipoInstrumento findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
