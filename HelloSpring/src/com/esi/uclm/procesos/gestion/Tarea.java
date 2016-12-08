package com.esi.uclm.procesos.gestion;

public class Tarea {
	String nombre;
	String prioridad;
	String pertenece;
	String fecha;
	String notas;
	String estado;
	
	public Tarea(String nombre, String prioridad, String pertenece, String fecha, String notas, String estado) {
		super();
		System.out.println("Tarea creada");
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
	public String getPertenece() {
		return pertenece;
	}
	public void setPertenece(String pertenece) {
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
}
