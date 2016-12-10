package stepDefination;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.esi.uclm.procesos.controller.MongoDB;
import com.esi.uclm.procesos.gestion.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class a_login {

	
	Usuario usuario;
	Usuario usuario1;
	@Given("^Definimos el nombre y password$")
	public void Definimos_nombre_password() throws Throwable {
		usuario=new Usuario("1", "luis", "luis", "pablito@gmail.com", "admin");
		//usuario= MongoDB.consultar_usuario("1");
		//usuario= new Usuario("4", "gfdgdfgd", "dfgdgdfgd", "julito", "admin");

	} 

	@Given("^Definimos el nombre y password que no existen$")
	public void Definimos_nombre_password_no_existentes() throws Throwable {
		usuario1= new Usuario("4", "gfdgdfgd", "dfgdgdfgd", "sddgdg", "user");

	} 
	@When("^Comprobamos login en la bd$")
	public void Comprobamos_bd() throws Throwable{
		MongoDB.comprobar_user_pass(usuario.getUser(), usuario.getPassword());
	}
	@When("^Comprobamos login en la bd mal$")
	public void Comprobamos_bd_mal() throws Throwable{
		MongoDB.comprobar_user_pass(usuario1.getUser(), usuario1.getPassword());
	}
	
	@Then("^Logearse bien$")
	public void Comprobar_login() throws Throwable{
		assertTrue(MongoDB.consultar_id(usuario.getId(),"usuarios"));
		}
	
	@Then("^Login repetido$")
	public void repecticion() throws Throwable{
			
		assertFalse(MongoDB.consultar_id(usuario1.getId(),"usuarios"));
	}
	
}
