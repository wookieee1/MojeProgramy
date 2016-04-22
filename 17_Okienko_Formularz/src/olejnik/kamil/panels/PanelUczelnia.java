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

public class PanelUczelnia extends JPanel implements ActionListener{
	
	private JButton btLewo;
	private JButton btPrawo;
	private JTextField tfId;
	private JLabel lNazwa;
	private JTextField tfNazwa;
	private JLabel lMiejscowosc;
	private JTextField tfMiejscowosc;
	private JLabel lRokZalozenia;
	private JTextField tfRokZalozenia;
	private JLabel lNazwaRektora;
	private JTextField tfNazwaRektora;
	private JButton btWstaw;
	private JButton btUsun;
	private JButton btMod;
	
	private JFrame frame;
	
	public static boolean okienkoAktywne;
	
	public PanelUczelnia(JFrame frame)
	{
		super(new BorderLayout());
		this.frame = frame;
		
		JPanel panelGora = new JPanel(new GridLayout(1, 3));
		JPanel panelSrodkowy = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel panelDol = new JPanel(new GridLayout(1, 3));
		
		btLewo = new JButton("<");
		tfId = new JTextField(10);
		btPrawo = new JButton(">");
		
		lNazwa = new JLabel("Nazwa");
		tfNazwa = new JTextField(15);
		tfNazwa.setFont(new Font("Arial", Font.PLAIN, 12));
		lMiejscowosc = new JLabel("Miejscowosc");
		tfMiejscowosc = new JTextField(15);
		tfMiejscowosc.setFont(new Font("Arial", Font.PLAIN, 12));
		lRokZalozenia = new JLabel("Rok Zalozenia");
		tfRokZalozenia = new JTextField(15);
		tfRokZalozenia.setFont(new Font("Arial", Font.PLAIN, 12));
		lNazwaRektora = new JLabel("Nazwa Rektora");
		tfNazwaRektora = new JTextField(15);
		tfNazwaRektora.setFont(new Font("Arial", Font.PLAIN, 12));
		
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
		
		panelSrodkowy.add(lNazwa);
		panelSrodkowy.add(tfNazwa);
		panelSrodkowy.add(lMiejscowosc);
		panelSrodkowy.add(tfMiejscowosc);
		panelSrodkowy.add(lRokZalozenia);
		panelSrodkowy.add(tfRokZalozenia);
		panelSrodkowy.add(lNazwaRektora);
		panelSrodkowy.add(tfNazwaRektora);
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
				JFrame frame = new JFrame("DODAWANIE UCZELNI");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //zamknie tylko nowo otwarty formularz
				PanelFormularzUczelnia panel = new PanelFormularzUczelnia(frame);
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
