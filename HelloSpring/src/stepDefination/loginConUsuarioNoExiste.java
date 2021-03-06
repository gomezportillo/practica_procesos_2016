package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginConUsuarioNoExiste {

	WebDriver driver = new FirefoxDriver();

	@Given("^Abre Mozilla Firefox$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");
		Thread.sleep(1000);
	}

	@When("^Insertamos nombre y pass en la barra$")
	public void Insertamos_nombre_contraseña() throws Throwable {
		WebElement barraNombre = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		barraNombre.sendKeys("asdfasdfasdfasd");
		password.sendKeys("pabfasdfasdfasdfasdfasdflo");;
		Thread.sleep(1000);
	}
	
	@Then("^boton de aceptar$")
	public void aceptar() throws Throwable {
		WebElement boton= driver.findElement(By.name("aceptar"));
		boton.click();
		Thread.sleep(1000);
	}	

	@Then("^se cierra el navegador$")
	public void cerraremos_el_navegador() throws Throwable {
	    driver.quit();
	}
}
