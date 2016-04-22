package olejnik.kamil.main;
import java.util.List;

import javax.swing.JFrame;

import olejnik.kamil.classes.Student;
import olejnik.kamil.classes.Uczelnia;
import olejnik.kamil.database.Database;
import olejnik.kamil.panels.PanelGlowny;


public class Main {

	//metoda spina panel z oknem glownym programu
	public static void createAndShowGui()
	{
		//obiekt klasy JFrame posluzy do utworzenia nowego okienka
		JFrame frame = new JFrame("FORMULARZ");
		//ustawiamy co mamy zrobic gdy nacisniemy czerwony krzyzyk - chcemy zamknac okienko
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//tworzymy obiekt panelu i ustawiamy mu widocznosc
		PanelGlowny panel = new PanelGlowny(frame);
		panel.setVisible(true);
		//panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //pozwala dodawac komponenty w ramch jednego wiersza 
		//od prawej do lewej czyli najpierw pierwszy na prawo, pozniej drugi itd
		
		//ladujemy zawartosc panelu do framea
		frame.setContentPane(panel);
		//frameowi nadajemy rozmiary, ktore dopasuje je do komponentow znajdujacych sie aktualnie
		//w okienku, to dlatego kiedy nie masz komponentow okienko jest male
		frame.pack();
		//ustawiamy okienko na widoczne
		frame.setVisible(true);
		//ustawiamy mozliwosc rozciagania okienka
		frame.setResizable(false);
		//dodajemy do glownego okna menu z klasu PanelGlowny
		frame.setJMenuBar(panel.createMenuBar());
		//pozycja okienka
		//int dx = centerPoint.x - windowSize.width / 2;
        //int dy = centerPoint.y - windowSize.height / 2;
        final int mainXPos = 100;
        final int mainYPos = 100;
        frame.setLocation(mainXPos, mainYPos);
	}
	public static void main(String[] args) {
		
		Database.connect();
		Database.createTables();
		
		Database.updateStudent(1, "Roman", "Dmowski", 62, 4);
		
		List<Student> listS = Database.selectStudent();
		for (Student s : listS)
		{
			System.out.println(s);
		}
		
		//Database.insertUczelnia("US", "Katowice", 1900, "Rysio");
		//Database.insertUczelnia("Politechnika", "Gliwice", 1950, "Bogdan");
		//Database.insertUczelnia("Wyzsza Szkola", "Sosnowiec", 19710, "Marian");
		
		Database.updateUczelnia("UJ", "Krakow", 1890, "Kazimierz", 2);
		
		List<Uczelnia> ListU = Database.selectUczelnia();
		for (Uczelnia u : ListU)
		{
			System.out.println(u);
		}
		//Database.insertStudent("Adam", "Nowak", 33, 1);
		//Database.insertStudent("Aldona", "Makita", 23, 2);
		//Database.insertStudent("Swa", "Bosch", 34, 3);
		//Database.insertStudent("Kamil", "Pionek", 34, 2);
		//teraz zeby okienko ruszylo musimy utworzyc specjalny watek
		//w ramach tego watku w metodzie run rusza nasza metoda, ktora powoduje ze iokienko sie pojawia
		//i od tej pory czeka na wszelkie zdarzenia, ktore w tym okienku zachodza i reaguje na nie
		
		/*
		javax.swing.SwingUtilities.invokeLater(
				new Runnable()
				{
					public void run()
					{
						createAndShowGui();
					}
				}
		);
		*/
		
	}

}
