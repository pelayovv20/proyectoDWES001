package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Currela extends Empleado implements Serializable{	//CLASE QUE DEPENDE DE LA CLASE EMPLEADO
	
	private double salario = 0.0;
	
	//CONSTRUCTOR POR DEFECTO
	public Currela() {
		
	}
	
	//CONSTRUCTOR DE AMBAS CLASES
	public Currela(Empleado e, double s) {
		super(e);
		this.salario = s;
	}

	//CONSTRUCTOR CON TODOS LOS AGRUMENTOS. TIENE LOS ARGUMENTOS DEL EMPLEADO MAS LOS SUYOS
	public Currela(Long id, String nombre, int edad, LocalDate fechanac, boolean vip,
		ConjuntoNominas conjunto, double salario) {
	super(id, nombre, edad, fechanac, vip,  conjunto);
	this.salario = salario;
	}

	//GETTERS Y SETTERS
	public double getSalario() {
		return salario;
	}

	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	//HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salario);
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
		Currela other = (Currela) obj;
		return Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}

	//TO STRING
	@Override
	public String toString() {
		return super.toString() + "\nsalario=" + this.salario;
	}
	
	
}