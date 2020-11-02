package proyectoCarrito;

public class ListaDoble<T> {
	// Atributo
	private NodoDoble<T> raiz;

	public ListaDoble () {
		raiz = new NodoDoble<T>();
	}

	/*
	public boolean Empty() {
		return Raiz.getSig() == null;
	}
	 */

	private NodoDoble<T> Inicio() {
		return raiz;
	}

	public NodoDoble<T> Primero() {
		return raiz.getSig();
	}

	/*
	public int indexOf(int Clave) {
		NodoDoble<T> aux = Primero();
		int cont = 1;
		while (aux != null && aux.getElNodo() != null) {
			Producto p = (Producto) aux.getElNodo().getDato();
			if (!p.equals(Clave)) {
				aux.Avanza();
				cont++;
			} else
				break;
		}
		return aux != null && aux.getElNodo() != null ? cont : Integer.MAX_VALUE;
	}

	public int indexOf(Object dato) {
		NodoDoble<T> aux = Primero();
		int cont = 0;
		while (aux != null && aux.getElNodo() != null) {
			Object tmp = aux.getElNodo().getDato();
			if (!tmp.equals(dato)) {
				aux.Avanza();
				cont++;
			} else
				break;
		}
		return aux != null && aux.getElNodo() != null ? cont : -1;
	}
	 */

	public NodoDoble<T> Ultimo() {
		NodoDoble<T> aux = raiz;
		while (aux.getSig() != null)
			aux = aux.getSig();
		return aux;
	}

	public void addFirst(T datos) {
		add(datos, Inicio());
	}

	public void addLast(T datos) {
		add(datos, Ultimo());
	}

	public void add(T datos) {
		add(datos, Ultimo());
	}

	public void add(T datos, int indice) {
		NodoDoble<T> aux = Inicio();
		int cont = 0;
		while (aux.getSig() != null && cont < indice) {
			aux = aux.getSig();
			cont++;
		}
		add(datos, aux);
	}

	// NA = Nodo Actual
	public void add(T datos, NodoDoble<T> NA) {
		if (NA != null) {
			NA.setSig(new NodoDoble<>(NA, datos, NA.getSig()));
			if (NA.getSig().getSig() != null)
				NA.getSig().getSig().setAnt(NA.getSig());
		}
	}

	public void remove(int indice) {
		NodoDoble<T> aux = Inicio();
		int cont = 0;
		while (aux.getSig() != null && cont < indice) {
			aux = aux.getSig();
			cont++;
		}
		if (aux.getSig() != null) {
			aux.setSig(aux.getSig().getSig());
			if (aux.getSig() != null)
				aux.getSig().setAnt(aux);
		}
	}
	
	public void update() {
		
	}

	public T get(int indice) {
		NodoDoble<T> aux = Primero();
		int cont = 0;
		while (aux != null && cont < indice) {
			aux = aux.getSig();
			cont++;
		}
		return aux.getDato();
	}

	public NodoDoble<T> getFirst() {
		return raiz.getSig();
	}
	
	public int size() {
		NodoDoble<T> aux = Inicio();
		int cont = 0;
		while (aux.getSig() != null) {
			aux = aux.getSig();
			cont++;
		}
		return cont;
	}
}
