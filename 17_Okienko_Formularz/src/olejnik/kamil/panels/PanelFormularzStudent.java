package olejnik.kamil.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormularzStudent extends JPanel implements ActionListener{
	private JLabel lImie;
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JTextField tfWiek;
	private JTextField tfRok;
	private JLabel lRok;
	private JButton btWstaw;
	private JButton btCancel;
	
	private JFrame frame;
	public PanelFormularzStudent(JFrame frame)
	{
		super(new GridLayout(5,2,5,5));
		this.frame = frame;
		lImie = new JLabel("Imie");
		tfImie = new JTextField(15);
		tfImie.setFont(new Font("Arial", Font.PLAIN, 12));
		lNazwisko = new JLabel("Nazwisko");
		tfNazwisko = new JTextField(15);
		tfNazwisko.setFont(new Font("Arial", Font.PLAIN, 12));
		lWiek = new JLabel("Wiek");
		tfWiek = new JTextField(15);
		tfWiek.setFont(new Font("Arial", Font.PLAIN, 12));
		lRok = new JLabel("Rok studiow");
		tfRok = new JTextField(15);
		tfRok.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btWstaw = new JButton("WSTAW");
		btWstaw.addActionListener(this);
		btCancel = new JButton("CANCEL");
		btCancel.addActionListener(this);
		
		add(lImie);
		add(tfImie);
		add(lNazwisko);
		add(tfNazwisko);
		add(lWiek);
		add(tfWiek);
		add(lRok);
		add(tfRok);
		add(btWstaw);
		add(btCancel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCancel)
		{
			//zeby zamknac okienko, musze wywolac dla framea w ktorym okienko odpalilem metode
			//dispose
			PanelStudent.okienkoAktywne = false;
			frame.dispose();
		}
		
	}
}
