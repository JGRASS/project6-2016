package studenti.gui.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import studenti.Student;
/**
 * Klasa Table model za studenta
 * @author Andjela
 *
 */
public class StudentTableModel extends AbstractTableModel{
	/**
	 * Niz koji sadrzi stringovi koji se odnose na nazive kolona 
	 */
	private final String[] kolone = new String[] {"Ime i prezime","Broj indeksa","Opis","Prosek" };
	/**
	 * Lista studenata
	 */
	private LinkedList<Student> studenti;
	/**
	 * Konstruktor za klasu StudentTableModel
	 * @param studenti Lista koja sadrzi objekte tipa student
	 */
	public StudentTableModel(LinkedList<Student> studenti) {
		if(studenti==null){
			this.studenti= new LinkedList<>();
		}else this.studenti = studenti;
	}
	/**
	 * Vraca broj kolona
	 * @return Broj kolona
	 */
	@Override
	public int getColumnCount() {
		
		return kolone.length;
	}
	/**
	 * Vraca broj redova
	 * @return Broj redova
	 */
	@Override
	public int getRowCount() {
		
		return studenti.size();
	}
	/**
	 * Vraca vrednost iz tabele u odredjenom redu i koloni 
	 * @param Odgovarajuci red iz kog zelimo da dobijemo podatak 
	 * @param Odgovarajuca kolona 
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student s = studenti.get(rowIndex);
		switch (columnIndex) {
		case 0: return s.getImeIPrezime();
		case 1: return s.getBrojIndeksa();
		case 2: return s.getDodatneAktivnosti();
		case 3: return s.getProsek();
		default: return "NN";
		
		}
		}
	
	/**
	 * Vraca ime kolone koja je npr. 5 po redu
	 * @return Naziv kolone
	 */
	@Override
	public String getColumnName(int column) {
			return kolone[column];
	}
	/**
	 * Puni se lista studenata listom koja je prosledjena kao parametar i osvezava tabela
	 * @param studenti Lista objekata tipa student
	 */
	public void ucitajStudente(LinkedList<Student> studenti){
		this.studenti=studenti;
		fireTableDataChanged();
	}
	/**
	 * Vraca objekat klase student koji se nalazi na trazenem mestu u listi ili tabeli
	 * @param index Indeks objekta koji nam je potreban 
	 * @return Objekat klase student
	 */
	public Student getStudentByIndex(int index){
		return studenti.get(index);
	}
	
}
