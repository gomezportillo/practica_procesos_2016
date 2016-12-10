package stepDefination;

import com.esi.uclm.procesos.gestion.Tarea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class h_listar_tareas {

	Tarea t;
	@Given("^Definimos una como mostrar$")
	public void Como_mostrar_lista() throws Throwable {
		t= new Tarea("1", "hacer los test", "324",  "pablo", "4/3/1999", "vamos señor",  "por hacer");
	} 

	@When("^Mostrarmos lista de tareas$")
	public void Mostramos_lista_tareas(){
	//	MongoDB.insertar_tarea(t.getNombre());
	}
	
	@Then("^Comprobamos que existen las de la lista$")
	public void Comprobar_lista() throws Throwable {
		//asserTrue(MongoDB.buscar_tarea(t.getNombre()));
	}
}
