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
private JButton jbtn_ok;
	
	
	public acerca() {
		
		setSize(423, 252);
		setTitle("Acerca de este programa");
		setIconImage(Toolkit.getDefaultToolkit().getImage(acerca.class.getResource("/Recursos/txt.png")));
		getContentPane().setLayout(null);
		
		JLabel acercaLabel = new JLabel("Este programa se encuentra bajo los terminos de la Licencia\n GPLV2\n");
		acercaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		acercaLabel.setBounds(0, 11, 393, 49);
		getContentPane().add(acercaLabel);
		
		jbtn_ok = new JButton("OK");
		jbtn_ok.setBounds(31, 179, 89, 23);
		getContentPane().add(jbtn_ok);
		
		JLabel lblProgramadores = new JLabel("Programadores: ");
		lblProgramadores.setBounds(31, 46, 113, 14);
		getContentPane().add(lblProgramadores);
		
		JLabel lblDelroyCenteno = new JLabel("Delroy Centeno");
		lblDelroyCenteno.setBounds(31, 71, 102, 14);
		getContentPane().add(lblDelroyCenteno);
		
		JLabel lblAlexanderCanales = new JLabel("Alexander Canales");
		lblAlexanderCanales.setBounds(31, 96, 113, 14);
		getContentPane().add(lblAlexanderCanales);
		
		JLabel lblEstudiantesDeLa = new JLabel("Estudiantes De la Universidad De Costa Rica.");
		lblEstudiantesDeLa.setBounds(31, 121, 293, 14);
		getContentPane().add(lblEstudiantesDeLa);
		jbtn_ok.addActionListener(this);
		jbtn_ok.addActionListener(this);
		
		
		
	}


	public void actionPerformed(ActionEvent e) { //Registra el evento del boton
		
		
		if(e.getSource()==jbtn_ok){
		
		Editor_texto edita = new Editor_texto();
		edita.setVisible(true);
		setVisible(false);
				
		}
	
		
	}//fin de actionPerformed
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//FIN DE LA CLASE
