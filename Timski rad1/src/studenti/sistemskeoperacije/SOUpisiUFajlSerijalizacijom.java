package studenti.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import studenti.Student;

public class SOUpisiUFajlSerijalizacijom {

	public static void izvrsi(LinkedList<Student> studenti){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.txt")));
			
				out.writeObject(studenti);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
