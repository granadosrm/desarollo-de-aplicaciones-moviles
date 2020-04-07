package mx.edu.tesoem.isc.sqlite_practica1_crud.entidades;

import java.io.Serializable;

public class Usuario implements Serializable
{
	private Integer id;
	private String nombre;
	private String telefono;

	public Usuario() {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
