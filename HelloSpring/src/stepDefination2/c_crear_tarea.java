package stepDefination2;


import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import com.esi.uclm.procesos.gestion.MongoDB;
import com.esi.uclm.procesos.gestion.Tarea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class c_crear_tarea {

	
	Tarea t;
	
	@Given("^definimos una tarea$")
	public void Creamos_tarea() throws Throwable {
	
		t=new Tarea("1","hacer el registro","32", "pablo", "2/5/2010","agkfdlgdfkogikjsdgnbi", "hecho");
	} 

	@When("^creamos una tarea$")
	public void Insertar_tarea() throws Throwable{
		try {
			MongoDB.insertar_tarea(t);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^comprobamos que esta creada la tarea$")
	public void aceptar() throws Throwable {
		assertTrue((MongoDB.consultar_id(t.getId(), "tareas")));
	}
}
