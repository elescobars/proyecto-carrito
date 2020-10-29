package proyectoCarrito;

public class Producto {

	// Atributos
	private int clave;
	private String descripcion;
	private float precio;

	public Producto(int clave, String descripcion, float precio) {
		this.clave = clave;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String toString() {
		return "Producto [Clave: " + clave + ", Descripcion: " + descripcion + ", Precio: " + precio +"]";
	}

	public boolean equals(Producto pass) {
		return this.clave == pass.clave;
	}

}
