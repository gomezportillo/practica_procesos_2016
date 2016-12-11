package stepDefination2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.esi.uclm.procesos.gestion.MongoDB;
import com.esi.uclm.procesos.gestion.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class a_login {

	
	private Usuario usuario;
	private Usuario usuario1;
	
	
	@Given("^Definimos el nombre y password$")
	public void Definimos_nombre_password() throws Throwable {
		usuario=new Usuario("1", "luis", "luis", "pablito@gmail.com", "admin");
	} 

	@Given("^Definimos el nombre y password que no existen$")
	public void Definimos_nombre_password_no_existentes() throws Throwable {
		usuario1= new Usuario("8", "luis", "ffasdfasfsa", "sddgdg", "user");
		
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
	public void login_repetido() throws Throwable{			
		System.out.println("/n /n /n"+usuario1.getId());
		assertFalse(MongoDB.consultar_id(usuario1.getId(),"usuarios"));
	}
	
}
