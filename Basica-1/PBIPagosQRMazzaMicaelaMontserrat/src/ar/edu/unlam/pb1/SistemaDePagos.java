package ar.edu.unlam.pb1;

import java.util.Arrays;

public class SistemaDePagos {

	private String nombre;
	private Producto listaDeProductos[];
	private Venta ventasDelDia[];
	private final int CANTIDAD_MAXIMA_DE_VENTAS= 20; //
	private final int CANTIDAD_MAXIMA_DE_PRODUCTOS=20;
	private int contadorDeVentas;

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */

	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el
	 * correcto funcionamiento
	 * 
	 * @param nombre - Este es el nombre del sistema
	 */
	public SistemaDePagos(String nombre) {
		this.nombre = nombre;
		this.listaDeProductos = new Producto[CANTIDAD_MAXIMA_DE_PRODUCTOS];
		this.ventasDelDia = new Venta [CANTIDAD_MAXIMA_DE_VENTAS];
		this.contadorDeVentas=0;

	}

	/****
	 * Agrega una nuevo producto
	 * 
	 * @param nuevo Producto
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {
		
		for (int i = 0; i < listaDeProductos.length; i++) {
			if(listaDeProductos[i] == null) {
				listaDeProductos[i] = nuevo;
				return true;
			}
			
		}
		
		return false;
	}


	
	/****
	 * bUSCAR UN PRODUCTO POR CODIGO
	 * 
	 * @param codigo del producto buscado
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public Producto buscarProducto(int codigo) {
		Producto buscado =null;
		
		for (int i = 0; i < listaDeProductos.length; i++) {
			if(listaDeProductos[i] != null && listaDeProductos[i].getCodigo() == codigo) {
				buscado = listaDeProductos[i];
				return buscado;  
				
			}
			
		}

		return buscado;
	}

	/***
	 * Genera un nuevo c�digo QR para una nueva compra. El mismo se debe generar de
	 * manera aleatoria, pero no puede repetirse, es decir se debe verificar que no
	 * se haya generado para otra compra anterior. Su valor est� dado entre 1000 y
	 * el valor m�ximo que soporta el tipo de dato Long
	 * 
	 * @return nuevo c�digo QR
	 */
	public long generarNuevoCodigoQR() {
		long codigo;
		
       codigo = (long) ((Math.random()* Long.MAX_VALUE)+1000);
       
       elCodigoQRExiste(codigo);
		
	
		return codigo;
	}

	/***
	 * Este es el m�todo que verifica si el c�digo QR exista. Es invocado desde el
	 * m�todo generarNuevoCodigoQR
	 * 
	 * @return nuevo c�digo QR
	 */
	public boolean elCodigoQRExiste(long codigoQR) {
		boolean repetido;

		do {
			repetido = false;

			for (int i = 0; i < ventasDelDia.length; i++) {
				if(ventasDelDia[i] != null && ventasDelDia[i].getCodigoQR() == codigoQR) {
					return true;
				}
			}

		} while(repetido);
		

		return false;
	}

	/****
	 * Agrega una nueva compra
	 * 
	 * @param nueva Compra
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarVenta(Venta nueva) {

		for (int i = 0; i < ventasDelDia.length; i++) {
			if(ventasDelDia[i] == null ) {
				ventasDelDia[i] = nueva;
				contadorDeVentas++;
				return true;
			}
			
		}

		return false;
	}

	/****
	 * Calcula el improte total de las ventas realizadas
	 * 
	 * @return importe total de las ventas realizadas
	 */
	public double calcularImporteTotal() {
		double montoFinal=0.0;
		
		for (int i = 0; i < ventasDelDia.length; i++) {
			if(ventasDelDia[i]!=null) {
				
			montoFinal += ventasDelDia[i].getImporteTotal();
			}
			
		}
		
		return montoFinal;
	}

	/****
	 * Calcula el improte promedio de las ventas realizadas
	 * 
	 * @return importe promedio de las ventas realizadas
	 */
	public double calcularImportePromedio() {
		
		double importePromedio=0.0;
		
		importePromedio = calcularImporteTotal() / contadorDeVentas; 
		
		

		return importePromedio;
	}

	@Override
	
	/****
	 * Devuelve en formato String un resumen de las ventas realizadas
	 * 
	 * @return Listado de las ventas realizadas
	 */

	public String toString() {
		String mensaje = " Sistema " + nombre.toUpperCase();
		
		
   mensaje += "  Las ventas realizadas en el dia son : " + contadorDeVentas + "\n"+
                         Arrays.toString(ventasDelDia) + "]";
   
   
   return mensaje;
	}

  






}
