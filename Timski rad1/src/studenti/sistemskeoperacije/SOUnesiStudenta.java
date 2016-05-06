package studenti.sistemskeoperacije;

import java.util.LinkedList;

import studenti.Student;

public class SOUnesiStudenta {

	public static void izvrsi(Student s, LinkedList<Student> studenti){
		studenti.add(s);
		SOUpisiUFajlSerijalizacijom.izvrsi(studenti);
	}
}
