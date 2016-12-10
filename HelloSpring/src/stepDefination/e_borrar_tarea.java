package stepDefination;

import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import com.esi.uclm.procesos.controller.MongoDB;
import com.esi.uclm.procesos.gestion.Tarea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class e_borrar_tarea {
	
	Tarea t;
	
	@Given("^seleccionamos una tarea para borrar$")
	public void Seleccionamos_tarea_borrar() throws Throwable {
		t= new Tarea("1", "hacer los test", "324",  "pablo", "4/3/1999", "vamos señor",  "por hacer");
	} 

	@When("^borramos una tarea a$")
	public void Borrar_tarea(){
		try {
			MongoDB.eliminar_tarea(t.getNombre());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^comprobamos que esta borrada la tarea$")
	public void Comprobar_tarea_borrada() throws Throwable {
		assertTrue((MongoDB.consultar_id(t.getId(), "tareas")));
	}
}
