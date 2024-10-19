package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//CLASE QUE DEPENDE DE LA CLASE EMPLEADO
public class Departamento {
	private Long id;
	private String nombre;
	
	//Lo inicializo como HashSet para que no esté a nulo. CARGA PESADA-->OBJETO COMPLETO DE TIPO EMPLEADO
	private Set <Empleado> empleados = new HashSet <Empleado>(); 
	
	//CONSTRUCTOR POR DEFECTO
	public Departamento() {

	}

	//CONSTRUCTOR CON TODOS LOS ATRIBUTOS
	public Departamento(Long id, String nombre, Set<Empleado> empleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empleados = empleados;
	}

	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	
	//TO STRING
	@Override
	public String toString() {
		String ret = "";
		ret += "idDepto: " + this.id;
		ret += "\nnombre?: " + this.nombre;
		ret += "\nEmpleados del departamento: ";
		
		for(Empleado e: this.empleados) { //BUCLE PARA RECORRER LA COLECCION
			ret +="\n" + e;
		}
		return ret;
	}
	

}
