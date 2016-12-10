package stepDefination2;

import static org.junit.Assert.assertFalse;

import java.net.UnknownHostException;

import com.esi.uclm.procesos.gestion.MongoDB;
import com.esi.uclm.procesos.gestion.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class f_modificar_usuario {
	Usuario u;
	Usuario u_antiguo;
	
	
	@Given("^seleccionamos el usuario que queremos modificar$")
	public void Seleccionamos_tarea_modificar() throws Throwable {
		u_antiguo=new Usuario("1", "luis", "luis", "pablito@gmail.com", "admin");

		u=new Usuario("1","pablo", "luis", "pablo@hotmail", "admin");
	} 

	@When("^modificamos un usuario$")
	public void Modificar_tarea_bd(){		
		try {
			MongoDB.modificar_usuario(u);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^comprobamos que esta modificada el usuario$")
	public void Comprobar_modificacion() throws Throwable {
		assertFalse(u.equals(u_antiguo));
	}

}
