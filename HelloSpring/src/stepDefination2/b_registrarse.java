package stepDefination2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import com.esi.uclm.procesos.gestion.MongoDB;
import com.esi.uclm.procesos.gestion.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class b_registrarse {


	Usuario usuario;
	@Given("^creamos un usuario$")
	public void Creamos_usuario() throws UnknownHostException  {
		
		usuario= new Usuario("4","pedro", "pedro", "julito", "admin");
		
	} 
	@Given("^creamos un usuario que este ya en la bd$")
	public void Creamos_usuario_repetido() throws UnknownHostException  {
		
		usuario=new Usuario("1", "luis", "luis", "pablito@gmail.com", "admin");
		
	} 

	@When("^lo registramos en la bd$")
	public void registrar_bd(){
		
		try {
			MongoDB.inserta_usuario(usuario);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Comprobar si esta bien$")
	public void Comprobar_registro() throws Throwable {
	
		assertTrue((MongoDB.comprobar_user_pass(usuario.getUser(), usuario.getPassword())).equals("admin"));
		MongoDB.eliminar_usuario(usuario.getId());
	}
	@Then("^Comprobar que esta repetido$")
	public void Comprobar_registro_repetido() throws Throwable {
	
		assertFalse((MongoDB.comprobar_user_pass(usuario.getUser(), usuario.getPassword())).equals("admin"));
	}
	
}
