package olejnik.kamil.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormularzUczelnia extends JPanel implements ActionListener{
	
	private JLabel lNazwa;
	private JTextField tfNazwa;
	private JLabel lMiejscowosc;
	private JTextField tfMiejscowosc;
	private JLabel lRokZalozenia;
	private JTextField tfRokZalozenia;
	private JLabel lNazwaRektora;
	private JTextField tfNazwaRektora;
	private JButton btWstaw;
	private JButton btCancel;
	
	private JFrame frame;
	
	public PanelFormularzUczelnia(JFrame frame)
	{
		super(new GridLayout(5,2,5,5));
		this.frame = frame;
		//frame.setResizable(true);
						
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
		btCancel = new JButton("Cancel");
		btCancel.addActionListener(this);
	
		add(lNazwa);
		add(tfNazwa);
		add(lMiejscowosc);
		add(tfMiejscowosc);
		add(lRokZalozenia);
		add(tfRokZalozenia);
		add(lNazwaRektora);
		add(tfNazwaRektora);
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
