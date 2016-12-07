package com.esi.uclm.procesos.gestion;

public class Usuario {
	String user;
	String password;
	String email;
	String rol;

	public Usuario(String user, String password, String email, String rol) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
