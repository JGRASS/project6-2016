package studenti;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import studenti.gui.PrikazStudenataGUI;
public class GrupaStudenti {
	private LinkedList<Student> studenti = new LinkedList<>();
	private static PrikazStudenataGUI prikaz= new PrikazStudenataGUI();
	public LinkedList<Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(LinkedList<Student> studenti) {
		this.studenti = studenti;
	}
	public void unesiStudenta(Student s){
		studenti.add(s);
		prikaz.osveziTabelu();
		upisiUFajlSerijalizacijom();
	}
	
	public void upisiUFajlSerijalizacijom(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.txt")));
			
				out.writeObject(studenti);
			
			
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public void ucitajIzFajlaDeserijalizacijom(){
		try {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("studenti.txt")));
		LinkedList<Student> studenti2 = (LinkedList<Student>) (in.readObject());
		studenti.clear();
		studenti.addAll(studenti2);

		in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public LinkedList<Student> vratiSveStudente(){
		return studenti; 
	}
	public LinkedList<Student> vratiPretrazeneStudente(String trazeno) {
		LinkedList<Student> pretrazeni = new LinkedList<Student>();
		for(Student s: studenti){
			if(s.getBrojIndeksa().contains(trazeno) 
					|| s.getImeIPrezime().toLowerCase().contains(trazeno)
					|| s.getImeIPrezime().toUpperCase().contains(trazeno)
					|| s.getImeIPrezime().contains(trazeno)){
					
				pretrazeni.add(s);
			}
			
		}
		return pretrazeni;
	}
	
	
	
}
