package olejnik.kamil.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelStudent extends JPanel implements ActionListener{
	
	private JButton btLewo;
	private JButton btPrawo;
	private JTextField tfId;
	private JLabel lImie;
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JTextField tfWiek;
	private JTextField tfRok;
	private JLabel lRok;
	private JButton btWstaw;
	private JButton btUsun;
	private JButton btMod;
	
	private JFrame frame;
	public static boolean okienkoAktywne;
	
	public PanelStudent (JFrame frame)
	{
		super (new BorderLayout());
		this.frame =frame;
		
		JPanel panelGora = new JPanel(new GridLayout(1, 3));
		JPanel panelSrodkowy = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel panelDol = new JPanel(new GridLayout(1, 3));
	
		btLewo = new JButton("<");
		tfId = new JTextField(10);
		btPrawo = new JButton(">");
		
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
		
		btWstaw = new JButton("Wstaw");
		btWstaw.addActionListener(this);
		btUsun = new JButton("Usun");
		btUsun.addActionListener(this);
		btMod = new JButton("Modyfikuj");
		btMod.addActionListener(this);
		
		panelGora.add(btLewo);
		panelGora.add(tfId);
		panelGora.add(btPrawo);
		//panelGora.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		panelSrodkowy.add(lImie);
		panelSrodkowy.add(tfImie);
		panelSrodkowy.add(lNazwisko);
		panelSrodkowy.add(tfNazwisko);
		panelSrodkowy.add(lWiek);
		panelSrodkowy.add(tfWiek);
		panelSrodkowy.add(lRok);
		panelSrodkowy.add(tfRok);
		panelSrodkowy.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		panelDol.add(btWstaw);
		panelDol.add(btUsun);
		panelDol.add(btMod);
		//panelDol.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		add(panelGora, BorderLayout.PAGE_START);
		add(panelSrodkowy, BorderLayout.CENTER);
		add(panelDol, BorderLayout.PAGE_END);
		
		okienkoAktywne = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btWstaw)
		{
			if (okienkoAktywne == false)
			{
				JFrame frame = new JFrame("DODAWANIE STUDENTA");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //zamknie tylko nowo otwarty formularz
				PanelFormularzStudent panel = new PanelFormularzStudent(frame);
				panel.setVisible(true);
				frame.setContentPane(panel);
				frame.pack();
				frame.setVisible(true);
				frame.setResizable(false);
				final int XPos = 500;
		        final int YPos = 100;
		        frame.setLocation(XPos, YPos);
		        okienkoAktywne = true;
	        }
		}
		
	}

}
