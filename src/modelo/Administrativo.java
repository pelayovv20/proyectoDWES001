package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Administrativo extends Empleado {	//CLASE QUE DEPENDE DE LA CLASE EMPLEADO
	
	private char categoria;
	

	//CONSTRUCTOR POR DEFECTO
	public Administrativo() {
		super();
	}

	//CONSTRUCTOR CON TODOS LOS AGRUMENTOS. TIENE LOS ARGUMENTOS DEL EMPLEADO MAS LOS SUYOS
	public Administrativo(Long id, String nombre, int edad, LocalDate fechanac, boolean vip,  char categoria, ConjuntoNominas c) {
		super(id, nombre, edad, fechanac, vip, c);
		this.categoria = categoria;
	}


	//GETTERS Y SETTERS
	public char getCategoria() {
		return categoria;
	}


	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}


	//HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(categoria);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrativo other = (Administrativo) obj;
		return categoria == other.categoria;
	}


	@Override
	public String toString() {
		return "Administrativo [categoria=" + categoria + ", id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", fechanac=" + fechanac + ", vip=" + vip + "]";
	}

	

}
