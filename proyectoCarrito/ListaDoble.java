package proyectoCarrito;

public class ListaDoble<t> {

	private NodoDoble<t> root;

	public ListaDoble() {
		root = new NodoDoble<t>();
	}


	private NodoDoble<t> start() {
		return root;
	}

	private NodoDoble<t> first() {
		return root.getNext();
	}

	private NodoDoble<t> last() {
		NodoDoble<t> aux = root;
		while (aux.getNext() != null) {
			aux = aux.getNext();
		}

		return aux;
	}

	public void addFirst(t dato) {
		add(dato, start());
	}

	public void addLast(t dato) {
		add(dato, last());
	}

	public void add(t dato) {
		add(dato, last());
	}

	public void add(int indice, t dato) {
		NodoDoble<t> aux = start();
		int cont = 0;
		while (aux.getNext() != null && cont < indice) {
			aux = aux.getNext();
			cont++;
		}
		add(dato, last());
	}

	public void add(t dato, NodoDoble<t> PN) {
		if(PN != null) {
			PN.setNext(new NodoDoble<t>(dato, PN, PN.getNext()));

			if(PN.getNext().getNext() != null)
				PN.getNext().getNext().setPrevious(PN.getNext());
		}
	}

	public void remove(int indice) {
		NodoDoble<t> aux = start();
		int cont = 0;
		while (aux.getNext() != null && cont < (indice-1)) {
			aux = aux.getNext();
			cont++;
		}

		if (aux.getNext() != null) {
			aux.setNext(aux.getNext().getNext());
			if(aux.getNext() != null) {
				aux.getNext().setPrevious(aux);
			}
		}
	}

	public t get(int indice) {
		NodoDoble<t> aux = first();
		int cont = 0;
		while (aux != null && cont < indice) {
			aux = aux.getNext();
			cont++;
		}
		return aux != null ? aux.getDato() : null;
	}

	public int size() {
		NodoDoble<t> aux = start();
		int cont = 0;
		while (aux.getNext() != null) {
			aux = aux.getNext();
			cont++;
		}
		return cont;
	}

}
