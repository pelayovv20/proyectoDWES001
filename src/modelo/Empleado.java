package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Empleado implements Comparable<Empleado> { // Cuando se hace un new primero entra aquí
	protected Long id;
	protected String nombre = "Emp";
	protected int edad;
	protected LocalDate fechanac;
	protected boolean vip = false;

	protected ConjuntoNominas conjunto;

	private Set <Long> departamentos = new HashSet <Long>(); //Carga ligera
	
	//private int[] colec = new int[] { 0, 0 };
	
	

	// Los constructores sirven para construir objetos a nuestro gusto
	// Por ejemplo, empleados de distntas maneras con distintos campos en cada caso
	
	public Empleado() { // Luego entra aquí en el constructor. CONSTRUCTOR POR DEFECTO

	}

	public Empleado(Empleado e) {// CONSTRUCTOR DE COPIA
		this.edad = e.edad;
		this.fechanac = e.fechanac;
		this.id = e.id;
		this.nombre = e.nombre;
		this.vip = e.vip;
		//this.colec = new int[] { e.colec[0], e.colec[1] }; // Hay que tener cuidado con los arrays, que suponen un problema													
		this.conjunto = e.conjunto;
	}
	
	//CONSTRUCTOR CON TODOS LOS ARGUMENTOS
	public Empleado(Long id, String nombre, int edad, LocalDate fechanac, boolean vip, ConjuntoNominas conjunto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechanac = fechanac;
		this.vip = vip;
		//this.colec = new int[] { colec[0], colec[1] }; // this.colec = colec ES UNA CAGADA, tiene que ser como está en el código	
		this.conjunto = conjunto;
	}

	//CONSTRUCTOR PERSONALIZADO
	public Empleado(Long id, int edad, LocalDate fechanac) {
		super();
		this.id = id;
		this.edad = edad;
		this.fechanac = fechanac;
	}
	
	
	//GETTERS Y SETTERS PARA PODER ACCEDER A ATRIBUTOS DE CLASES EN OTRAS CLASES DIFERENTES
	public void setId(Long id) { 
		this.id = id;

	}

	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechanac() {
		return fechanac;
	}

	public void setFechanac(LocalDate fechanac) {
		this.fechanac = fechanac;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public ConjuntoNominas getConjunto() {
		return conjunto;
	}

	public void setConjunto(ConjuntoNominas conjunto) {
		this.conjunto = conjunto;
	}


	

	
	//HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + Arrays.hashCode(colec);
		result = prime * result + Objects.hash(conjunto, edad, fechanac, id, nombre, vip);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return  Objects.equals(conjunto, other.conjunto) && edad == other.edad
				&& Objects.equals(fechanac, other.fechanac) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && vip == other.vip;
	}

	//TO STRING PARA PODER MOSTRAR LOS DATOS DE UN EMPLEADO EN UN SYSTEM.OUT.PRINTLN
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", fechanac=" + fechanac + ", vip="
				+ vip + ", conjunto=" + conjunto ;
	}

	
	//METODO COMPARE TO PARA COMPARAR DOS ELEMENTOS DE TIPO EMPLEADO POR DISTINTOS ATRIBUTOS
	@Override
	public int compareTo(Empleado o) {
//		if (this.getEdad()==o.getEdad()) return 0;
//		else
//		if(this.getEdad()<o.getEdad()) return -1;
//		else
//		return 1 ;
		
		
	
		if(Integer.compare(this.getEdad(), o.getEdad())==0) {
			//DESEMPATAR
			return this.getFechanac().compareTo(o.getFechanac());
		}
		else return 1;
		
		
		
//	if (this.isVip() && ! o.isVip()) 
//		return -1;
//	else if(!this.isVip() && o.isVip())
//		return 1;
//	else
//		return this.getFechanac().compareTo(o.getFechanac());
		
		
	
		//return Integer.compare(this.getEdad(), o.getEdad());
	}
	
	
	
	
	

}

/*
 * Herencia flecha apuntando Asociación linea normal Dependecia -------> de la
 * que depende hacia la clase de la que depende Composición/Agregación Linea con
 * un rombo en el lado del todo (grande)
 */
