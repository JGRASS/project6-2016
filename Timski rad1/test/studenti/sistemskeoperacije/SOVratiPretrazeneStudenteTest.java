/**
 * 
 */
package studenti.sistemskeoperacije;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import studenti.Student;

/**
 * @author Andjela
 *
 */
public class SOVratiPretrazeneStudenteTest {
	LinkedList<Student> studenti, pretrazeni, studenti2;
	Student s1, s2, s3;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		studenti = new LinkedList<>();
		pretrazeni = new LinkedList<>();
		studenti2 = new LinkedList<>();
		s1 = new Student("Andjela Babic", "Nista", "47/14", 9.27);
		s2 = new Student("Marko Antic", "Tamo vamo", "44/14", 10.00);
		s3 = new Student("Dane Nikolic", "Slusam muziku", "41/14", 10.00);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		studenti = null;
		pretrazeni = null;
		studenti2 = null;
		s1 = null;
		s2 = null;
		s3 = null;
	}

	/**
	 * Test method for {@link studenti.sistemskeoperacije.SOVratiPretrazeneStudente#izvrsi(java.lang.String, java.util.LinkedList)}.
	 */
	@Test
	public void testIzvrsiProveruIndeks() {
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		pretrazeni = SOVratiPretrazeneStudente.izvrsi("47/1", studenti);
		studenti2 = new LinkedList<>();
		studenti2.add(s1);
		assertEquals(studenti2, pretrazeni);
	}
	
	@Test
	public void testIzvrsiProveruIme() {
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		pretrazeni = SOVratiPretrazeneStudente.izvrsi("Marko", studenti);
		studenti2 = new LinkedList<>();
		studenti2.add(s2);
		assertEquals(studenti2, pretrazeni);
	}

}
