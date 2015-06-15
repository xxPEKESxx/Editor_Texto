package Vista;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class acerca extends JFrame implements ActionListener {
	
	JButton btnOk;
	
	
	public acerca() {
		setTitle("Acerca de este programa");
		setIconImage(Toolkit.getDefaultToolkit().getImage(acerca.class.getResource("/Recursos/txt.png")));
		getContentPane().setLayout(null);
		
		JLabel acercaLabel = new JLabel("Este programa se encuentra bajo los terminos de la Licencia\n GPLV2\n");
		acercaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		acercaLabel.setBounds(31, 23, 393, 49);
		getContentPane().add(acercaLabel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(151, 202, 89, 23);
		getContentPane().add(btnOk);
		btnOk.addActionListener(this);
		
		
		
	}


	public void actionPerformed(ActionEvent e) { //Registra el evento del boton
		
		
		if(e.getSource()==btnOk){
		
		System.exit(DISPOSE_ON_CLOSE);
		
		
		}
	
		
	}//fin de actionPerformed

			
	
}//fin de la clase 
