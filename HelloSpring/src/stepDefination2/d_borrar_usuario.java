package stepDefination2;

import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import com.esi.uclm.procesos.gestion.MongoDB;
import com.esi.uclm.procesos.gestion.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class d_borrar_usuario {
	
	Usuario usuario;
	
	@Given("^seleccionamos un usuario$")
	public void Seleccionamos_usuario() throws Throwable {
		usuario= new Usuario("1","pablo", "pablo", "pablo@hotmail.com", "admin");
	} 

	@When("^borramos usuario$")
	public void Borrar_usuario(){
		try {
			MongoDB.eliminar_usuario(usuario.getUser());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^comprobamos que no esta$")
	public void aceptar() throws Throwable {
		assertTrue((MongoDB.consultar_id(usuario.getId(), "usuarios")));
	}
	
}
