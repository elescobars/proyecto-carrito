package proyectoCarrito;

public class NodoDoble <t> {
	private t dato;

	private NodoDoble<t> next, previous;

	public NodoDoble() {
		this(null,null,null);
	}

	public NodoDoble(t dato, NodoDoble<t> next, NodoDoble<t> previous) {
		this.dato = dato;
		this.next = next;
		this.previous = previous;

	}

	public t getDato() {
		return dato;
	}

	public void setDato(t dato) {
		this.dato = dato;
	}

	public NodoDoble<t> getNext() {
		return next;
	}

	public void setNext(NodoDoble<t> next) {
		this.next = next;
	}

	public NodoDoble<t> getPrevious() {
		return previous;
	}

	public void setPrevious(NodoDoble<t> previous) {
		this.previous = previous;
	}

}
