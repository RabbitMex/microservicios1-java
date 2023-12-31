/**
 * 
 */
package com.formacionbdi.springboot.app.item.models.service;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

/**
 * 
 */
@Service("serviceRestTemplate")
public class ItemServiceImp implements ItemService {
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		System.out.println("Implementado findAll RestTemplate");
		//List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
//		List<Item> items = new ArrayList<Item>();
//		for(Producto producto: productos) {
//			Item item = new Item(producto, 1);
//			items.add(item);
//		}
		//return items;
		return productos.stream().map(p->new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		System.out.println("Implementado findById RestTemplate");
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		//Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
