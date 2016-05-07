/**
 * 
 */
package studenti.sistemskeoperacije;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import studenti.Student;

/**
 * @author Andjela
 *
 */
public class SOVratiSveStudenteTest {
	LinkedList<Student> studenti = new LinkedList<>();
	LinkedList<Student> studenti2;
	/**
	 * Test method for {@link studenti.sistemskeoperacije.SOVratiSveStudente#izvrsi(java.util.LinkedList)}.
	 */
	@Test
	public void testIzvrsi() {
		Student s1 = new Student("Andjela Babic", "Nista", "47/14", 9.27);
		Student s2 = new Student("Marko Antic", "Tamo vamo", "44/14", 10.00);
		Student s3 = new Student("Dane Nikolic", "Slusam muziku", "41/14", 10.00);
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		studenti2 = SOVratiSveStudente.izvrsi(studenti);
		assertEquals(studenti, studenti2);
	}

}
