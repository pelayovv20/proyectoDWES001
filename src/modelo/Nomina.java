package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Nomina {

	private Long id;
	private double cantidad;
	private LocalDate fecha;

	//CONSTRUCTOR POR DEFECTO
	public Nomina() {

	}

	//CONSTRUCTOR CON TODOS LOS ARGUMENTOS
	public Nomina(Long id, double cantidad, LocalDate fecha) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, fecha, id);
	}

	//HASHCODE Y EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nomina other = (Nomina) obj;
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id);
	}
	
	
	//TO STRING
	@Override
	public String toString() {
		String ret = "";
		ret += "id: " + this.id;
		ret += "\ncantidad: " + this.cantidad;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
		ret += "\nfecha" + this.fecha.format(formateador);

		return ret;
	}

}
