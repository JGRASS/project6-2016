package studenti.gui.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import studenti.Student;

public class StudentTableModel extends AbstractTableModel{
	private final String[] kolone = new String[] {"Ime i prezime","Broj indeksa","Opis","Prosek" };
	private LinkedList<Student> studenti;
	
	public StudentTableModel(LinkedList<Student> studenti) {
		if(studenti==null){
			this.studenti= new LinkedList<>();
		}else this.studenti = studenti;
	}
	@Override
	public int getColumnCount() {
		
		return kolone.length;
	}
	@Override
	public int getRowCount() {
		
		return studenti.size();
	}
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
	
	
	@Override
	public String getColumnName(int column) {
			return kolone[column];
	}
	
	public void ucitajStudente(LinkedList<Student> studenti){
		this.studenti=studenti;
		fireTableDataChanged();
	}
	
	public Student getStudentByIndex(int index){
		return studenti.get(index);
	}
	
}
