package proyectoCarrito;

import java.util.Scanner;

public class AppCarrito {

	public static Scanner leer = new Scanner(System.in);

	private static ListaDoble<Carrito> carritos = new ListaDoble<Carrito>();

	public static void main(String[] args) {

		//Nodo pivote de referencia para el traslado en listas D
		NodoDoble<Carrito> nodoActual;

		int opcion = 0;
		do {
			opcion = menu();

			switch(opcion) {

			case 1: //Nuevo carrito
				System.out.print("Introduzca el nombre del carrito : ");
				String nombre = leer.next();
				if (carritos.size()==0) {
					ListaDoble<Producto> productos = new ListaDoble<Producto>();
					carritos.addFirst(new Carrito(nombre, 0, productos));
				} else {
					ListaDoble<Producto> productos = new ListaDoble<Producto>();
					carritos.addLast(new Carrito(nombre, 0, productos));
				}
				System.out.println("Carrito '"+nombre+"' creado !");
				break;

			case 2: //Eliminar carrito
				nodoActual = carritos.getFirst();
				if (carritos.size()!=0) {
					System.out.println("Introduzca el nombre del carrito a eliminar : ");
					nombre = leer.next();
					int cont = 0;
					while (nodoActual != null && !nodoActual.getDato().getNombre().equals(nombre)) {
						nodoActual = nodoActual.getSig();
						cont++;
					}
					if (nodoActual == null) {
						System.out.println("Carrito '"+nombre+"' no encontrado !");
					} else {
						carritos.remove(cont);
						System.out.println("Carrito '"+nombre+"' eliminado !");
					}
				} else {
					System.out.println("No hay carritos para eliminar !");
				}
				break;

			case 3: //Agregar al carrito, agrega un producto al carrito
				nodoActual = carritos.getFirst();
				if (carritos.size()!=0) {
					System.out.print("Introduzca el nombre del carrito : ");
					nombre = leer.next();
					int cont = 0;
					while (nodoActual != null && !nodoActual.getDato().getNombre().equals(nombre)) {
						nodoActual = nodoActual.getSig();
						cont++;
					}
					if (nodoActual == null) {
						System.out.println("Carrito '"+nombre+"' no encontrado !");
					} else {
						System.out.print("Introduzca la clave del producto : ");
						int cve = leer.nextInt();
						System.out.print("Introduzca el nombre del producto : ");
						String nombreProducto = leer.next();
						System.out.print("Introduzca el precio del producto : ");
						float precio = leer.nextFloat();
						carritos.get(cont).getProductos().add(new Producto(cve, nombreProducto, precio));
						System.out.println("Producto '"+nombreProducto+"' agregado al carrito '"+carritos.get(cont).getNombre()+"' !");
						System.out.println("El carrito : '"+carritos.get(cont).getNombre()+"' tiene "+carritos.get(cont).getProductos().size()+" producto(s) en su interior !");
					}
				} else {
					System.out.println("No hay carritos a los que agregar productos !");
				}
				break;

			case 4: //Cambiar producto, modifica un producto presente en un carrito ya existente
				nodoActual = carritos.getFirst();
				if (carritos.size()!=0) {
					System.out.print("Introduzca el nombre del carrito : ");
					nombre = leer.next();
					int cont = 0;
					while (nodoActual != null && !nodoActual.getDato().getNombre().equals(nombre)) {
						nodoActual = nodoActual.getSig();
						cont++;
					}
					if (nodoActual == null) {
						System.out.println("Carrito '"+nombre+"' no encontrado !");
					} else {
						NodoDoble<Producto> nodoActualProducto = carritos.get(cont).getProductos().getFirst();
						int contProductos = 0;

						System.out.print("Introduzca la clave del producto : ");
						int cve = leer.nextInt();
						while (nodoActualProducto != null && !(nodoActualProducto.getDato().getClave()==cve)) {
							nodoActualProducto = nodoActualProducto.getSig();
							contProductos++;
						}
						if (nodoActualProducto == null) {
							System.out.println("Producto con clave '"+cve+"' no encontrado !");
						} else {
							System.out.print("Introduzca la nueva clave de producto : ");
							carritos.get(cont).getProductos().get(contProductos).setClave(leer.nextInt());
							System.out.print("Introduzca la nueva descripcion de producto : ");
							carritos.get(cont).getProductos().get(contProductos).setDescripcion(leer.next());
							System.out.print("Introduzca el nuevo precio del producto : ");
							carritos.get(cont).getProductos().get(contProductos).setPrecio(leer.nextInt());
							System.out.println("El carrito : '"+carritos.get(cont).getNombre()+"' tiene "+carritos.get(cont).getProductos().size()+" producto(s) en su interior !");
						}

					}
				} else {
					System.out.println("No hay carritos a los que agregar productos !");
				}
				break;

			case 5: //Quitar del carrito, elimina un producto de un carrito existente
				nodoActual = carritos.getFirst();
				if (carritos.size()!=0) {
					System.out.print("Introduzca el nombre del carrito : ");
					nombre = leer.next();
					int cont = 0;
					while (nodoActual != null && !nodoActual.getDato().getNombre().equals(nombre)) {
						nodoActual = nodoActual.getSig();
						cont++;
					}
					if (nodoActual == null) {
						System.out.println("Carrito '"+nombre+"' no encontrado !");
					} else {
						NodoDoble<Producto> nodoActualProducto = carritos.get(cont).getProductos().getFirst();
						int contProductos = 0;

						System.out.print("Introduzca la clave del producto : ");
						int cve = leer.nextInt();
						while (nodoActualProducto != null && !(nodoActualProducto.getDato().getClave()==cve)) {
							nodoActualProducto = nodoActualProducto.getSig();
							contProductos++;
						}
						if (nodoActualProducto == null) {
							System.out.println("Producto con clave '"+cve+"' no encontrado !");
						} else {
							System.out.println("El producto '"+carritos.get(cont).getProductos().get(contProductos).getDescripcion()+"' ha sido eliminado !");
							carritos.get(cont).getProductos().remove(contProductos);
							System.out.println("El carrito : '"+carritos.get(cont).getNombre()+"' tiene "+carritos.get(cont).getProductos().size()+" producto(s) en su interior !");
						}

					}
				} else {
					System.out.println("No hay carritos de los que eliminar productos !");
				}
				break;

			case 6: //Total del carrito, calcula el total del valor de los productos en un carrito
				nodoActual = carritos.getFirst();
				if (carritos.size()!=0) {
					System.out.print("Introduzca el nombre del carrito : ");
					nombre = leer.next();
					int cont = 0;
					while (nodoActual != null && !nodoActual.getDato().getNombre().equals(nombre)) {
						nodoActual = nodoActual.getSig();
						cont++;
					}
					if (nodoActual == null) {
						System.out.println("Carrito '"+nombre+"' no encontrado !");
					} else {
						NodoDoble<Producto> nodoActualProductos = carritos.get(cont).getProductos().getFirst();
						while (nodoActualProductos != null) {
							System.out.println(nodoActualProductos.getDato());
							nodoActualProductos = nodoActualProductos.getSig();
						}
						carritos.get(cont).actualizaTotal();
						System.out.println("El total de los productos del carrito '"+(carritos.get(cont).getNombre())+"' es "+carritos.get(cont).getTotal());
					}
				} else {
					System.out.println("No hay carritos !");
				}
				break;

			case 7: //Total global, calcula el total del valor de todos los productos en todos los carritos
				nodoActual = carritos.getFirst();
				float totalGlobal = 0;
					while (nodoActual != null) {
						nodoActual.getDato().actualizaTotal();
						totalGlobal += nodoActual.getDato().getTotal();
						System.out.println(nodoActual.getDato());
						nodoActual = nodoActual.getSig();
					}
					System.out.println("El total de todos los carritos es de : "+totalGlobal);
				break;

			case 8: //Muestra el size
				System.out.println("Tamano de la lista : "+carritos.size());
				break;

			case 0: //Salir, termina el programa
				System.out.println("PROGRAMA TERMINADO");
				break;

			default:
				System.out.println("Opcion no valida !");
				break;
			}

		} while(opcion != 0);
		leer.close();
	}

	public static int menu() {
		System.out.println("--------------------------");
		System.out.println("MENU DE OPCIONES\n");
		System.out.println("1. Nuevo carrito");
		System.out.println("2. Eliminar carrito");
		System.out.println("3. Agregar al carrito");
		System.out.println("4. Cambiar producto");
		System.out.println("5. Quitar del carrito");
		System.out.println("6. Total del carrito");
		System.out.println("7. Total global");
		System.out.println("0. Salir");
		System.out.println("--------------------------");
		System.out.print("Opcion: ");

		return leer.nextInt();
	}

}
