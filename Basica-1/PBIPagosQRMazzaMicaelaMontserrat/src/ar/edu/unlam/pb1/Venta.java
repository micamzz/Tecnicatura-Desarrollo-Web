package ar.edu.unlam.pb1;

public class Venta {

	private String email;
	private String cuil;
	private long codigoQR;
	private double porcentajeDescuento;
	private double importeTotal;

	private Producto productosALaVenta[];
	private final int CANTIDAD_MAXIMA_DE_PRODUCTOS_POR_DIA=100;

	/****
	 * Constructor de la clase
	 * @param eMail eMail del Vendedor
	 * @param cuil del Vendedor
	 * @param codigoQR de la Venta
	 * @param porcentajeDescuento Determina el porcentaje de descuento asociado a la Venta. Su valor est� dado entre 0 y 1
	 */
	public Venta(String eMail, String cuil, long codigoQR, double porcentajeDescuento) {
		this.email = eMail;
		this.cuil = cuil;
		this.codigoQR = codigoQR;
		this.porcentajeDescuento = porcentajeDescuento;
		this.importeTotal=0.0;
		this.productosALaVenta = new Producto[CANTIDAD_MAXIMA_DE_PRODUCTOS_POR_DIA];
		
		
	}
	
	
	/****
	 * Devuelve el c�digo QR asociado a la Venta
	 * @return Devuelve el c�digo QR asociado a la Venta
	 */
	public long getCodigoQR() {
		return this.codigoQR;
	}

	/****
	 * Devuelve el E-Mail del Vendedor
	 * @param eMail
	 */
	public String getEMailVendedor() {
		return this.email;
	}

	/****
	 * Devuelve el CUIL del Vendedor
	 * @param cuil
	 */
	public String getCuilVendedor() {
		return this.cuil; 
	}

	/****
	 * Agrega un nuevo producto a la Venta
	 * @param nuevo Producto
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {
	
	for (int i = 0; i < productosALaVenta.length; i++) {
		
		if(productosALaVenta[i] == null){
			productosALaVenta[i] = nuevo;
			return true;			
		}
	
	}
	
		return false;
	}
	
	/****
	 * Calcula el importe total de la Venta, el cual est� dado por la sumatoria de los importes de los productos incluidos, menos el porcentaje de descuento
	 * @return Devuelve el importe total de la Venta
	 */
	public double getImporteTotal() {
		
		double sumaTotal=0.0;
		double porcentaje=0.0;
		
		for (int i = 0; i < productosALaVenta.length; i++) {
			if (productosALaVenta[i] != null) {
				
				porcentaje = productosALaVenta[i].getPrecio()  * this.porcentajeDescuento ;
				sumaTotal += productosALaVenta[i].getPrecio() - porcentaje;
			
			}
			
		}

		return sumaTotal;
	 
	}

	/****
	 * Devuelve informaci�n descripctiva de la Venta 
	 * @return String que describa el estado del objeto
	 */


	@Override
	public String toString() {
		return "Venta [email=" + email + ", cuil=" + cuil + ", codigoQR=" + codigoQR + ", porcentajeDescuento="
				+ porcentajeDescuento + ", importeTotal=" + this.getImporteTotal() + "]";
	}
	
	
}
