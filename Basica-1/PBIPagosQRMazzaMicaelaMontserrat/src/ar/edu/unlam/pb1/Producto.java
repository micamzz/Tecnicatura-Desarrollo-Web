package ar.edu.unlam.pb1;

public class Producto {
	
	private String descripcion;
	private double precio;
	private int codigo;

	/***
	 * Constructor de la clase
	 * @param codigo
	 * @param precio
	 * @param descripcion
	 */
	public Producto(int codigo, double precio, String descripcion) {
		this.codigo = codigo;
		this.precio = precio;
		this.descripcion = descripcion;
		
	}
	
	/****
	 * Devuelve el c�digo de un producto
	 * @return Devuelve el c�digo de un producto 
	 */
	public int getCodigo() {
		return this.codigo;
	}
	
	/****
	 * Devuelve el precio de un producto
	 * @return Devuelve el precio de un producto 
	 */
	public double getPrecio() {
		return this.precio;
	}
	
	/****
	 * Establece el precio de un producto
	 * @param precio - Precio del producto 
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
		
	}

	/****
	 * Devuelve la descripci�n de un producto
	 * @return Devuelve la descripci�n de un producto 
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/****
	 * Establece la descripcion de un producto
	 * @param descripcion - Descripci�n del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		
	}

	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", precio=" + precio + ", codigo=" + codigo + "]";
	}
	
	/****
	 * Devuelve informaci�n descripctiva del producto 
	 * @return String que describa el estado del objeto
	 */
	
}
