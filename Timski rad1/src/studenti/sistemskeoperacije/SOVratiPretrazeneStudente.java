package studenti.sistemskeoperacije;

import java.util.LinkedList;

import studenti.Student;

public class SOVratiPretrazeneStudente {

	public static LinkedList<Student> izvrsi(String trazeno, LinkedList<Student> studenti) {
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
