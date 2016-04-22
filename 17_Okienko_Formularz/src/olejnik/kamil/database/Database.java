package olejnik.kamil.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import olejnik.kamil.classes.Student;
import olejnik.kamil.classes.Uczelnia;

public class Database {
	private final static String DRV = "org.sqlite.JDBC";
	private final static String DB = "jdbc:sqlite:Dziekanat.db";
	
	private static Connection conn; //zarzadza polaczeniem z baza danych
	private static Statement stat; //zarzadza zapytaniami z baza danych
	
	public static void connect()
	{
		try {
			Class.forName(DRV); //ladowanie sterownika
			conn = DriverManager.getConnection(DB); //nawiazywanie polaczenia z baza danych, polaczenie bedzie
			//reprezentowane przez zmienna conn
			stat = conn.createStatement(); //inijclizacja zmiennej od zarzadzania zapytaniami sql
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTables()
	{
		String createStudent = "CREATE TABLE IF NOT EXISTS Student (idS integer primary key autoincrement, imie varchar(50), nazwisko varchar(50), wiek integer, rokStudiow integer);";
		String createUczelnia = "CREATE TABLE IF NOT EXISTS Uczelnia (idU integer primary key autoincrement, nazwa varchar(50), miejscowosc varchar(50), rokZalozenia integer, nazwaRektora varchar(50));";
		try {
			stat.execute(createStudent);
			stat.execute(createUczelnia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertStudent(String imie, String nazwisko, int wiek, int rokStudiow)
	{
		String insertS = "INSERT INTO Student (imie, nazwisko, wiek, rokStudiow) VALUES (?, ?, ?, ?);";
		try {
			PreparedStatement ps = conn.prepareStatement(insertS);
			ps.setString(1, imie);
			ps.setString(2, nazwisko);
			ps.setInt(3, wiek);
			ps.setInt(4, rokStudiow);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateStudent(int id, String imie, String nazwisko, int wiek, int rokStudiow)
	{
		String updateS = "UPDATE Student SET imie=?, nazwisko=?, wiek=?, rokStudiow=? WHERE idS=?;";
	
		
		try {
			PreparedStatement ps = conn.prepareStatement(updateS);
			ps.setString(1, imie);
			ps.setString(2, nazwisko);
			ps.setInt(3, wiek);
			ps.setInt(4, rokStudiow);
			ps.setInt(5, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteStudent(int id)
	{
		String deleteS = "DELETE FROM Student WHERE idS=?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(deleteS);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Student> selectStudent()
	{
		List<Student> lista = new ArrayList<>();
		String selectS = "SELECT * FROM Student;";
		
		try {
			ResultSet rs =stat.executeQuery(selectS);
			int id, wiek, rokStudiow;
			String imie, nazwisko;
			
			while(rs.next())
			{
				id = rs.getInt("idS");
				imie = rs.getString("imie");
				nazwisko = rs.getString("nazwisko");
				wiek = rs.getInt("wiek");
				rokStudiow = rs.getInt("rokStudiow");
				lista.add(new Student(id, imie, nazwisko, wiek, rokStudiow));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Student> selectStudentByImie(String imiee)
	{
		List<Student> lista = new ArrayList<>();
		String selectS = "SELECT * FROM Student WHERE imie LIKE ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(selectS);
			ps.setString(1, imiee);
			
			ResultSet rs = ps.executeQuery();
			int id, wiek, rokStudiow;
			String imie, nazwisko;
			
			while(rs.next())
			{
				id = rs.getInt("idS");
				imie = rs.getString("imie");
				nazwisko = rs.getString("nazwisko");
				wiek = rs.getInt("wiek");
				rokStudiow = rs.getInt("rokStudiow");
				lista.add(new Student(id, imie, nazwisko, wiek, rokStudiow));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	
	public static void insertUczelnia(String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora)
	{
		String insertU = "INSERT INTO Uczelnia (nazwa, miejscowosc, rokZalozenia, nazwaRektora) VALUES (?, ?, ?, ?);";
		try {
			PreparedStatement ps = conn.prepareStatement(insertU);
			ps.setString(1, nazwa);
			ps.setString(2, miejscowosc);
			ps.setInt(3, rokZalozenia);
			ps.setString(4, nazwaRektora);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateUczelnia (String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora, int id)
	{
		String updateU = "UPDATE Uczelnia SET nazwa=?, miejscowosc=?, rokZalozenia=?, nazwaRektora=? WHERE idU=?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(updateU);
			ps.setString(1, nazwa);
			ps.setString(2, miejscowosc);
			ps.setInt(3, rokZalozenia);
			ps.setString(4, nazwaRektora);
			ps.setInt(5, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteUczelnia (int id)
	{
		String deleteU = "DELETE FROM Uczelnia WHERE idU=?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(deleteU);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Uczelnia> selectUczelnia()
	{
		List<Uczelnia> lista = new ArrayList<>();
		String selectU = "SELECT * FROM Uczelnia;";
		
		try {
			ResultSet rs =stat.executeQuery(selectU);
			int id, rokZalozenia;
			String nazwa, miejscowosc, nazwaRektora;
			
			while(rs.next())
			{
				id = rs.getInt("idU");
				nazwa = rs.getString("nazwa");
				miejscowosc= rs.getString("miejscowosc");
				rokZalozenia = rs.getInt("rokZalozenia");
				nazwaRektora= rs.getString("nazwaRektora");
				lista.add(new Uczelnia(id, nazwa, miejscowosc, rokZalozenia, nazwaRektora));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}
