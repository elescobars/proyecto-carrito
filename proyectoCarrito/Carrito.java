package proyectoCarrito;

public class Carrito {

	// Atributos
	private String nombre;
	private float total;
	private ListaDoble<Producto> productos;
	
	public Carrito(String nombre, float total, ListaDoble<Producto> productos) {
		this.nombre = nombre;
		this.total = total;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}

	public float getTotal() {
		return total;
	}

	public ListaDoble<Producto> getProductos() {
		return productos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void setProductos(ListaDoble<Producto> productos) {
		this.productos = productos;
	}

}
