package klase;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class GrupaStudenti {
	private LinkedList<Student> studenti = new LinkedList<>();
	
	public void unesiStudenta(Student s){
		studenti.add(s);
		upisiUFajlSerijalizacijom();
	}
	
	public void upisiUFajlSerijalizacijom(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("clanovi.out")));
			for (int i = 0; i < studenti.size(); i++) {
				out.writeObject(studenti.get(i));
			}
			
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
