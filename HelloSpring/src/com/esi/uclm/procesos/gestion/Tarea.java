package com.esi.uclm.procesos.gestion;

import java.util.HashSet;
import java.util.Set;

public class Tarea {
	String id;

	String nombre;
	String prioridad;
	Set<String> pertenece = new HashSet<String>();
	String fecha;
	String notas;
	String estado;
	
	public Tarea(String id,String nombre, String prioridad, Set<String> pertenece, String fecha, String notas, String estado) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.prioridad = prioridad;
		this.pertenece = pertenece;
		this.fecha = fecha;
		this.notas = notas;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public Set<String> getPertenece() {
		return pertenece;
	}
	public void setPertenece(Set<String> pertenece) {
		this.pertenece = pertenece;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
