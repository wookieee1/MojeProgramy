package olejnik.kamil.panels;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelGlowny extends JPanel implements ActionListener{
	private PanelStudent ps;
	private PanelUczelnia pu;
	
	private JMenuItem menuItemPanelStudent;
	private JMenuItem menuItemPanelUczelnia;
	
	private JFrame frame;
	
	public PanelGlowny(JFrame frame)
	{
		super(new CardLayout()); //przelaczane panele
		this.frame = frame;
		
		menuItemPanelStudent = new JMenuItem("PANEL STUDENT");
		menuItemPanelStudent.addActionListener(this);
		menuItemPanelUczelnia = new JMenuItem("PANEL UCZELNIA");
		menuItemPanelUczelnia.addActionListener(this);
		
		ps = new PanelStudent(this.frame);
		pu = new PanelUczelnia(this.frame);
		
		//dodajemy kazdy panel z etykieta
		add(ps, "PS");
		add(pu, "PU");
	}
	
	public JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("MENU");
		
		
		menu.add(menuItemPanelStudent);
		menu.add(menuItemPanelUczelnia);
		
		menuBar.add(menu);
		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuItemPanelStudent)
		{
			//musimy pobrac aktualny layout a nastepnie ustwic mu ktory panel ma wyswietlac
			CardLayout cL = (CardLayout)getLayout();
			cL.show(this, "PS");
		}
		else if (e.getSource() == menuItemPanelUczelnia)
		{
			CardLayout cL = (CardLayout)getLayout();
			cL.show(this, "PU");
		}
		
	}

	
}
