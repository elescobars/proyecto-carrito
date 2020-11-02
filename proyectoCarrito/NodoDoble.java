package proyectoCarrito;

public class NodoDoble <t> {

	private t dato;

	private NodoDoble<t> sig, ant;

	public NodoDoble(NodoDoble<t> Ant, t Dato, NodoDoble<t> Sig) {
		ant = Ant;
		dato = Dato;
		sig = Sig;
	}
	public NodoDoble() {
		this(null, null, null);
	}


	public t getDato() {
		return dato;
	}

	public void setDato(t dato) {
		this.dato = dato;
	}

	public NodoDoble<t> getSig() {
		return sig;
	}

	public void setSig(NodoDoble<t> sig) {
		this.sig = sig;
	}
	public NodoDoble<t> getAnt() {
		return ant;
	}
	public void setAnt(NodoDoble<t> ant) {
		this.ant = ant;
	}

}
