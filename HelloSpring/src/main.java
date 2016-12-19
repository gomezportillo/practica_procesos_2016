import com.esi.uclm.procesos.gestion.EmailSender;

public class main {

	public static void main(String[] args) {
		EmailSender e = new EmailSender("pedroma.almagro@gmail.com");
		e.send();
	}

}
