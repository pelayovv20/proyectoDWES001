package modelo;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoNominas {

	private Long id;
	private boolean pagado;

	//CONJUNTO DE TIPO NOMINA LLAMADO NOMINAS. SERA UN HASHSET
	private Set<Nomina> nominas = new HashSet<Nomina>(); // Utilizo un conjunto (SET) en vez de una list porque los
															// conjuntos no admiten duplicados, las listas sí
	//CONSTRUCTOR POR DEFECTO
	public ConjuntoNominas() { 

	}

	//CONSTRUCTOR CON T0D0S LOS ARGUMENTOS
	public ConjuntoNominas(Long id, boolean pagado, Set<Nomina> nominas) {
		super();
		this.id = id;
		this.pagado = pagado;
		this.nominas = nominas;
	}

	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Set<Nomina> getNominas() {
		return nominas;
	}

	public void setNominas(Set<Nomina> nominas) {
		this.nominas = nominas;
	}
	
	
	//HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(id, nominas, pagado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjuntoNominas other = (ConjuntoNominas) obj;
		return Objects.equals(id, other.id) && Objects.equals(nominas, other.nominas) && pagado == other.pagado;
	}
	
	//TO STRING
	@Override
	public String toString() {
		String ret = "";
		ret += "idCjto: " + this.id;
		ret += "\npagado?: " + this.pagado;
		
		for(Nomina n: this.nominas) { //BUCLE PARA RECORRER LA COLECCIÓN
			ret +="\n" + n;
		}
		return ret;
	}
	
	
	
}
