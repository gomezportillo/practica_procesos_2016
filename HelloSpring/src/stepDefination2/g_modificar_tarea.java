package stepDefination2;

import static org.junit.Assert.assertFalse;

import java.net.UnknownHostException;

import com.esi.uclm.procesos.gestion.MongoDB;
import com.esi.uclm.procesos.gestion.Tarea;
import com.esi.uclm.procesos.gestion.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class g_modificar_tarea {

	Tarea t;
	Tarea t_antigua;

	@Given("^seleccionamos una tarea para modificar$")
	public void Seleccionamos_tarea_modificar() throws Throwable {
		t_antigua = new Tarea("1","hacer el registro","32", "pablo", "2/5/2010","agkfdlgdfkogikjsdgnbi", "hecho");


		 t=new Tarea("1","encargar pista", "100", "pablo", "5/4/2010", "asdfffasdf", "Terminado");
	} 

	@When("^modificamos una tarea$")
	public void Modificar_tarea_bd(){		
		try {
			MongoDB.modificar_tarea(t);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^comprobamos que esta modificada la tarea$")
	public void Comprobar_modificacion_tarea() throws Throwable {
		assertFalse(t_antigua.equals(t));
	}

}
