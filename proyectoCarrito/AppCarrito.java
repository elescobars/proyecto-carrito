package proyectoCarrito;

import java.util.Scanner;

public class AppCarrito {

	public static Scanner leer = new Scanner(System.in);

	private static ListaDoble<Carrito> carritos = new ListaDoble<Carrito>();

	public static void main(String[] args) {

		int opcion = 0;
		do {
			opcion = menu();

			switch(opcion) {

			case 1: //Nuevo carrito
				System.out.print("Introduzca el nombre del carrito : ");
				String nombre = leer.next();
				ListaDoble<Producto> productos = new ListaDoble<Producto>();
				carritos.add(new Carrito(nombre, 0, productos));
				System.out.println("Carrito '"+nombre+"' creado !");
				break;

			case 2: //Eliminar carrito
				if (carritos.size()!=0) {
					System.out.println("Introduzca el nombre del carrito a eliminar : ");
				} else {
					System.out.println("No hay carritos para eliminar !");
				}
				break;

			case 3: //Agregar al carrito
				break;

			case 4: //Cambiar producto
				break;

			case 5: //Quitar del carrito
				break;

			case 6: //Total del carrito
				break;

			case 7: //Total global
				break;

			case 0: //Salir
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
