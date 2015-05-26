package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;


public class cambio extends JFrame implements ActionListener {
	

	 
	 
	private JTextField BuscatextField;
	private JTextField cambiartextField;
	JButton btnBuscacambia;
	
	public cambio() {
		setTitle("Busqueda y reemplazo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(cambio.class.getResource("/Recursos/txt.png")));
		getContentPane().setLayout(null);
		
		BuscatextField = new JTextField();
		BuscatextField.setBounds(108, 33, 228, 30);
		getContentPane().add(BuscatextField);
		BuscatextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese el caracter o cadena a buscar.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(98, 11, 228, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIngreseElCaracter = new JLabel("Ingrese el caracter o cadena a para cambiar ");
		lblIngreseElCaracter.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElCaracter.setBounds(108, 85, 228, 22);
		getContentPane().add(lblIngreseElCaracter);
		
		cambiartextField = new JTextField();
		cambiartextField.setColumns(10);
		cambiartextField.setBounds(108, 104, 228, 30);
		getContentPane().add(cambiartextField);
		
		JButton btnBuscacambia = new JButton("Buscar y reemplazar");
		btnBuscacambia.setBounds(148, 145, 159, 41);
		getContentPane().add(btnBuscacambia);
		
		
		
		btnBuscacambia.addActionListener(this);
	
	  
		
	}//FIN de constructor 


	
	
	
	public String mandaBusca(){
		
		String send=BuscatextField.getText();
	
		return send;
	}
	
	
public String mandacambia(){
		
		String send2=cambiartextField.getText();
	
		return send2;
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {//Este metodo es el que le dara accion al boton de busqueda y cambio
	
       if(evento.getSource()==btnBuscacambia){
    	   
    	   mandaBusca();
    	   mandacambia();
       }
	
		
		
	}//fin de action performed 


	
	
	
	
	
	
	
}//fin de la clase 
