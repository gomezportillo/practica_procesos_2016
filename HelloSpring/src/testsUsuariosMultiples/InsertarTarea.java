package testsUsuariosMultiples;

import com.esi.uclm.procesos.gestion.Tarea;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InsertarTarea {
	
	Tarea tasktest;
	
	@Given("^The user creates a task with multiple users$")
	public void The_user_creates_a_task_with_multiple_users() throws Throwable {
		 String[] users= {"pablo", "manolo"};
	    tasktest =new Tarea("1","hacer el registro","32", users, "2/5/2010","agkfdlgdfkogikjsdgnbi", "hecho");
	}

	@When("^The user inserts all data$")
	public void The_user_inserts_all_data() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^The task is in data base$")
	public void The_task_is_in_data_base() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
