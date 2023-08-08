/**
 * 
 */
package com.formacionbdi.springboot.app.item.models;

/**
 * 
 */
public class Item {
	private Producto producto;
	private Integer cantidad;
	public Item() {
		super();
	}
	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * Metodo para obtener el total de un producto, se obtiene con el precio
	 * del producto multiplicado por la candidad de dicho producto.
	 * 
	 * @return total de los mismos productos.
	 */
	public Double getTotal()
	{
		return this.producto.getPrecio() * cantidad.doubleValue();
	}
	
//	public Double getDescuento() {
//		return this.producto.getPrecio() * cantidad.doubleValue() * 0.01;
//	}
}