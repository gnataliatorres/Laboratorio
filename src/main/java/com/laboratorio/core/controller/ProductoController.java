package com.laboratorio.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.laboratorio.core.model.Producto;
import com.laboratorio.core.service.ProductoService;

@Controller
@RequestMapping("/api/v1")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	
	//POST --> crear
		@RequestMapping(value="/producto", method=RequestMethod.POST,headers="Accept=application/json")
		public ResponseEntity<?> createProducto(@RequestBody Producto producto, UriComponentsBuilder ucBuilder){
			if(productoService.findByNombre(producto.getNombre())!=null) {
				return new ResponseEntity("Existe un producto con ese nombre, verifique e intente de nuevo.", HttpStatus.CONFLICT);
			}else {
				productoService.saveProducto(producto);
				HttpHeaders headers = new HttpHeaders();
				
				headers.setLocation(ucBuilder.path("/api/v1/producto/{id}").buildAndExpand(producto.getCodigoProducto()).toUri());
				return new ResponseEntity<String>(headers, HttpStatus.CREATED);
				
			}
			
		}
		//GET FINDBYNOMBRE
		@RequestMapping(value="/producto", method=RequestMethod.GET,headers="Accept=application/json")
		public ResponseEntity<List<Producto>> getProducto(@RequestParam(value="nombre", required = false) String nombre){
			
			List<Producto> productos = new ArrayList<Producto>();
			if(nombre != null) {
				Producto elemento = productoService.findByNombre(nombre);
				if(elemento == null) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}else {
					productos.add(elemento);
				}
			}else {
				productos = productoService.findAllProductos();
				if(productos.isEmpty() ) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity <List<Producto>>(productos, HttpStatus.OK);
		}
	
}
