package principal;

import java.time.LocalDate;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.*;
import utils.Utilidades;

public class Principal {

	public static void main(String[] args) {

		// ENTRADA Y SALIDA
		Scanner entrada = new Scanner(System.in);

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		try {
			System.out.println("Escribe una linea por teclado:");
			String linea = br.readLine();
			System.out.println("La cadena fue: " + linea + "\n");
		} catch (IOException e) {
			System.err.println("Se produjo una IOException: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		FileInputStream fis; // FLUJO BINARIO DE ENTRADA (LECTURA) DESDE FICHERO
		FileOutputStream fos; // FLUJO BINARIO DE SALIDA (ESCRITURA) HACIA FICHERO

		FileReader fr;
		try {

			fr = new FileReader("mifichero.txt"); // FLUJO DE CARACTERES DE ENTRADA (LECTURA) DESDE FICHERO DE
													// CARACTERES
			FileWriter fw; // FLUJO DE CARACTERES DE SALIDA (ESCRITURA) DESDE FICHERO DE CARACTERES
			br = new BufferedReader(fr);
			br.readLine();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e3) {

			e3.printStackTrace();

		}

		try {
			FileWriter fw = new FileWriter(".\\subcarpeta\\salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		File fichero = new File(".\\subcarpeta\\lectura.txt");
		FileReader flujoLectura;
		BufferedReader flujoBuffer = null;
		BufferedWriter bw;
		File fichsalida = new File("salida.txt");
		FileWriter fw = null;
		try {
			try {
				flujoLectura = new FileReader(fichero);
				flujoBuffer = new BufferedReader(flujoLectura);
				fw = new FileWriter(fichsalida,true);
				bw = new BufferedWriter(fw);
				String linea;
				while ((linea = flujoBuffer.readLine()) != null) {
					String[] partes = linea.split(" ");
					System.out.println(linea);
					bw.write(linea + "\n"); bw.flush();
				}

				System.out.println("Lectura/escritura del fichero completa");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			if (flujoBuffer != null || fw!=null)
				try {
					flujoBuffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
		
		
		
		
		

		// List <int> listaa = new ArrayList<int>(); //ERROR, HAY QUE USAR EL ENVOLTORIO
		// INTEGER
		List<Integer> listaaa = new ArrayList<Integer>();

		// RECORRER LISTAAA
		Iterator<Integer> it1 = listaaa.iterator();
		while (it1.hasNext()) {
			Integer i = it1.next();
			System.out.println(i);
		}

		// CONJUNTOS
		Set<Empleado> conjuntoEmpleadosHashSet = new HashSet<Empleado>(); // CONJUNTO DESORDENADO
		Set<Empleado> conjuntoEmpleadosLinkedHashSet = new LinkedHashSet<Empleado>(); // CONJUNTO ORDENADO SEGUN EL
																						// ORDEN DE INSERCION
		Set<Empleado> conjuntoEmpleadosTreeSet = new TreeSet<Empleado>(); // CONJUNTO ORDENADO SEGUN "COMPARE TO" DE
																			// EMPLEADO. AL SER STRING ES ALFABETICO

		// LISTAS
		List<Empleado> arrayListEmpleados = new ArrayList<>(); // LISTA ORDENADA POR INSERCION
		List<Empleado> linkedListEmpleados = new LinkedList<Empleado>(); // LISTA ORDENADA SEGUN COMPARE TO DE EMPLEADO
																			// ---->FACILITA LAS OPERACIONES EN LA
																			// CABEZA Y LA COLA DE LA LISTA
		List<Empleado> vectorEmpleados = new Vector<Empleado>(); // LISTA DE ACCESO SINCRONIZADO

		Empleado emp1 = new Empleado();
		Empleado emp2 = new Empleado();
		Empleado emp3 = new Empleado();
		Empleado emp4 = new Empleado();

		// AÑADIR A LA COLECCION EL EMP4
		boolean exito = arrayListEmpleados.add(emp4);
		// ELIMINAR A LA COLECCION EL EMP4
		exito = arrayListEmpleados.remove(emp4);

		// CREACIÓN DE UN NUEVO EMPLEADO LLAMADO E PIDIENDO TODOS SUS ATRIBUTOS
		Empleado e = new Empleado();
		System.out.println("NUEVO EMPLEADO");
		Scanner in = new Scanner(System.in);

		// EMPEZAMOS PIDIENDO POR TECLADO EL ID DEL EMPLEADO
		boolean valido = false;
		Long id = 0L;
		do {
			System.out.println("Dame su id");
			id = in.nextLong();
			if (id <= 0) {
				System.out.println("El id es inválido. Debe ser un entero mayor que 0");
			} else
				valido = true;

		} while (!valido);
		e.setId(id);

		// NOMBRE DEL EMPLEADO= "EMP" + ID
		e.setNombre(e.getNombre() + e.getId());

		// EDAD
		int edad = -1;
		valido = false;
		do {
			System.out.println("Dame su edad");
			edad = in.nextInt();
			if (edad <= 0) {
				System.out.println("La edad es inválida. Debe ser un entero mayor que 0");
			} else
				valido = true;
		} while (!valido);
		e.setEdad(edad);

		// FECHA DE NACIMIENTO. ACCDEMOS AL MÉTODO LEERFECHA() PARA VALIDAR LA FECHA QUE
		// PONGAMOS POR TECLADO
		valido = false;
		LocalDate fechaNac;
		do {
			System.out.println("Dame la fecha de nacimiento");
			fechaNac = Utilidades.leerFecha();
			if (fechaNac.isAfter(LocalDate.now().minusYears(18))) {
				System.out.println("La fecha de nacimiento no puede ser posterior a hoy");
			} else
				valido = true;
		} while (!valido);
		e.setFechanac(fechaNac);

		// VIP O NO MEDIANTE LEERBOOLEAN()
		System.out.println("El nuevo empleado es vip?");
		e.setVip(Utilidades.leerBoolean());

		// IMPRIMIR EL EMPLEADO E
		System.out.println("Empleado " + e.getId() + " añadido con éxito");
		System.out.println(e);

		/*
		 * int entero = 0; char c = 0; boolean b = false; double d = 0;
		 * System.out.println("La variable entero vale: " + entero);
		 * System.out.println("La variable c vale: " + c);
		 * System.out.println("La variable b vale: " + b);
		 * System.out.println("La variable d vale: " + d); String cadena = null;
		 * System.out.println("La variable cadena vale: " + cadena); LocalDateTime
		 * fechahora = LocalDateTime.now(); System.out.println("Hoy es: " +
		 * fechahora.getDayOfWeek()); DateTimeFormatter formateador =
		 * DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
		 * System.out.println("La fecha-hora actual es: " +
		 * fechahora.format(formateador)); fechahora = fechahora.plusHours(1);
		 * System.out.println("Son las " + fechahora.format(formateador) +
		 * "--> me piro a mi casa a comer");
		 * 
		 * Empleado e1 = new Empleado();
		 * 
		 * Empleado e2 = new Empleado(); e2.setNombre("Emp004"); e2.setId(2L);
		 * e2.setEdad(45); e2.setVip(true); System.out.println(e2.getId());
		 * System.out.println(e2);
		 */

//		Administrativo ad1 = new Administrativo(3L, "Administrativo1", 33, LocalDate.of(1990, Month.JANUARY, 1), true,
//				null, 'A');
//	System.out.println(ad1);
//
//		 Administrativo ad2 = e1; ERROR
//		Empleado e3=new Empleado((Empleado)ad1);
//		((Administrativo)e3).setCategoria('B'); //Convierto el e3 en un administrativo y le asigno la categoría B
//		System.out.println(e3);
//		Currela c1 = new Currela(e1, 1500.40); // Para hacer esto hice un nuevo constructor con esos valores
//		Currela c3 = new Currela(ad1, 2000);

	}// FIN DEL MAIN
}// FIN DE LA CLASE

//Toda asociación lleva un nombre (generalmente un verbo) (trabajar por ejemplo) como en BADAT
//Toda asociación lleva cardinalidades en la relación (valores máximos y minimos) 
//Multiplicidad: se usa la N y la M  Cardinalidad: se usan asteriscos
