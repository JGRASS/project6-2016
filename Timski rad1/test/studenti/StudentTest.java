/**
 * 
 */
package studenti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andjela
 *
 */
public class StudentTest {
	Student s;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	 s = new Student();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	 s= null;
	}

	/**
	 * Test method for {@link studenti.Student#Student(java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testStudent() {
		s = new Student("Andjela Babic", "JAVA", "47/14", 8.78);
		Student s2 = new Student();
		s2.setBrojIndeksa("47/14");
		s2.setDodatneAktivnosti("JAVA");
		s2.setImeIPrezime("Andjela Babic");
		s2.setProsek(8.78);
		assertEquals(s.toString(), s2.toString());
	}

	

	/**
	 * Test method for {@link studenti.Student#setImeIPrezime(java.lang.String)}.
	 */
	@Test
	public void testSetImeIPrezime() {
		s.setImeIPrezime("Andjela Babic");
		assertEquals("Andjela Babic", s.getImeIPrezime());
	}

	/**
	 * Test method for {@link studenti.Student#setDodatneAktivnosti(java.lang.String)}.
	 */
	@Test
	public void testSetDodatneAktivnosti() {
		s.setDodatneAktivnosti("Radim nesto");
		assertEquals("Radim nesto", s.getDodatneAktivnosti());
	}

	/**
	 * Test method for {@link studenti.Student#setBrojIndeksa(java.lang.String)}.
	 */
	@Test
	public void testSetBrojIndeksa() {
		s.setBrojIndeksa("44/15");
		assertEquals("44/15", s.getBrojIndeksa());
	}

	/**
	 * Test method for {@link studenti.Student#setProsek(double)}.
	 */
	@Test
	public void testSetProsek() {
		s.setProsek(8.4);
		assertEquals(8,4, s.getProsek());
	}
	
	@Test
	public void testToString() {
		s = new Student("Andjela", "Nesto", "5/14", 7.6);
		String s1 = "Ime i prezime: Andjela Br. indeksa: 5/14Opis: Nesto Prosek: 7.6";
		assertEquals(s1, s.toString());
	}

}
