package studenti.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import studenti.Student;

public class SOUcitajIzFajlaDeserijalizacijom {

	public static void izvrsi(LinkedList<Student> studenti){
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
}
