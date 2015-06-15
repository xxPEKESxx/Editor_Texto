package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;










import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JProgressBar;


import javax.swing.Timer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class carga extends JFrame  implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6766087688902719232L;
	private JLabel jl_infp;
	private JButton jbtn_comienza;
	private JButton jbtncancela;
	private JProgressBar jbp_progreso;
	private Timer tiempo;
	
	public carga() throws InterruptedException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				tiempo= new Timer(50,new progreso());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setTitle("ACTUALIZANDO");
		setSize(409,139);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		jl_infp = new JLabel("Actializando");
		jl_infp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_infp.setBounds(10, 0, 248, 14);
		panel.add(jl_infp);
		
		jbtn_comienza = new JButton("Comienza");
		jbtn_comienza.setBounds(10, 76, 108, 23);
		panel.add(jbtn_comienza);
		
		jbtncancela = new JButton("Cancelar");
		jbtncancela.setBounds(128, 76, 102, 23);
		panel.add(jbtncancela);
		
		jbp_progreso = new JProgressBar();
		jbp_progreso.setBackground(SystemColor.control);
		jbp_progreso.setBounds(10, 34, 383, 31);
		panel.add(jbp_progreso);
		jbtn_comienza.addActionListener(this);
		jbtncancela.addActionListener(this);
		
		
	
		
	}

	public void actionPerformed(ActionEvent accion) {
	if (accion.getSource()==jbtn_comienza) {
		tiempo.start();
		jl_infp.setText("Buscando actualizacion...");
		

	if (accion.getSource() == jbtncancela) {
		
		setVisible(false);
	}
	}
	}
	 public class progreso implements ActionListener{

		public void actionPerformed(ActionEvent accion) {
			int n = jbp_progreso.getValue();
			if (n<100) {
				n++;
				jbp_progreso.setValue(n);
				
				
			}else {
				tiempo.stop();
				JOptionPane.showMessageDialog(null, "Finalizada");
				setVisible(false);
				
			}
			
		}
		
		
	}
	}
