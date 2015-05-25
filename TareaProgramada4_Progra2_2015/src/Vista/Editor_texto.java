package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.KeyStroke;

import java.awt.Button;

import javax.swing.JTextField;
import javax.swing.JEditorPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Editor_texto extends JFrame implements ActionListener {
	private JPanel jp_edicion;
	private int size=17;
	private JTextArea jta_textoedicion;
	private JButton jbtn_Abrir;
	private JButton jbtn_guarda;
	private JButton jbtn_busca;
	private JButton jbtn_negrita;
	private JButton jbtn_italic;
	private JButton jbtn_bolditalic;
	private JComboBox<String> jcbx_sizetexto;
	private JComboBox<String> jcbx_tipofuente;
	private JMenuItem jmi_terminacon;
	private JMenuItem jmi_comienzacon;
	private JCheckBoxMenuItem jchx_paneledicion;
	private JMenuItem jmi_busca;
	private JMenuItem jmi_actualiza;
	private JMenuItem jmi_acercade;
	private JMenuItem jmi_nuevo;
	private JMenuItem jmi_abrir;
	private JMenuItem jmi_guardar;
	private JMenuItem jmi_salir;
	private JMenuItem jmi_imprime;
	private JButton jbtn_imprime;
	private JLabel lblPalabras;
	private JLabel jl_palabras;
	private JLabel lblLetras;
	private JLabel jl_letras;
	private JLabel lblNumeros;
	private JLabel jl_numeros;
	private JLabel lblConsonantes;
	private JLabel jl_consonantes;
	private JLabel lblCaracteres;
	private JLabel jl_caracteres;
	private JMenuItem mntmRemplazarCaracterpalabrasimboloEct;
	private JPanel panel_3;
	private JComboBox<String> jcbx_filtro;
	private JTextField jtf_busca;
	private JButton jbtn_salir2;
	private JToolBar jtoolBar;
	private JTextArea jta_muestrafiltro;
	private Font areaFuente;
	private boolean cierto=false;
	private JButton jbtn_limpia;
	String cualespalabras="";
	
	
	
	
	public Editor_texto() {
		setLocationRelativeTo(null);
		setSize(646,691);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar jmb_opciones = new JMenuBar();
		jmb_opciones.setBounds(0, 0, 573, 21);
		panel.add(jmb_opciones);
		
		JMenu mnArchivo = new JMenu("Archivo");
		jmb_opciones.add(mnArchivo);
		
		jmi_nuevo = new JMenuItem("Nuevo");
		jmi_nuevo.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/new.png")));
		jmi_nuevo.addActionListener(this);
		mnArchivo.add(jmi_nuevo);
		
		jmi_abrir = new JMenuItem("Abrir");
		jmi_abrir.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/open16x16.png")));
		jmi_abrir.addActionListener(this);
		
		mnArchivo.add(jmi_abrir);
		
		jmi_guardar = new JMenuItem("Guardar");
		jmi_guardar.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/save16x16.png")));
		jmi_guardar.addActionListener(this);
		mnArchivo.add(jmi_guardar);
		
		jmi_imprime = new JMenuItem("Imprimir");
		jmi_imprime.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/printer16x16.png")));
		jmi_imprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	imprimirDatos(evt);
            }
        });
		mnArchivo.add(jmi_imprime);
		
		jmi_salir = new JMenuItem("Salir");
		jmi_salir.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/salir.png")));
		mnArchivo.add(jmi_salir);
		
		JMenu mnVer = new JMenu("Ver");
		jmb_opciones.add(mnVer);
		
		jchx_paneledicion = new JCheckBoxMenuItem("Panel de edicion");
		jchx_paneledicion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				if (jchx_paneledicion.isSelected()) {
					
					jtoolBar.setVisible(true);
				}else {
					jtoolBar.setVisible(false);
					
				}
				
			}
		});
		jchx_paneledicion.setAccelerator(KeyStroke.getKeyStroke("ctrl 2"));
		//m2.setAccelerator(KeyStroke.getKeyStroke("ctrl 2"));
		jchx_paneledicion.addActionListener(this);
		mnVer.add(jchx_paneledicion);
		
		jmi_comienzacon = new JMenuItem("palabras que empiece con..");
		mnVer.add(jmi_comienzacon);
		
		jmi_terminacon = new JMenuItem("Palabras que terminan con ....");
		mnVer.add(jmi_terminacon);
		
		mntmRemplazarCaracterpalabrasimboloEct = new JMenuItem("Remplazar caracter(palabra,simbolo, ect)");
		mnVer.add(mntmRemplazarCaracterpalabrasimboloEct);
		
		JMenuItem menuItem = new JMenuItem("");
		mnVer.add(menuItem);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		jmb_opciones.add(mnAyuda);
		
		jmi_acercade = new JMenuItem("Acerca de...");
		mnAyuda.add(jmi_acercade);
		
		jmi_actualiza = new JMenuItem("Actualizar sofware");
		jmi_actualiza.addActionListener(this);
		mnAyuda.add(jmi_actualiza);
		
		jmi_busca = new JMenuItem("Buscar");
		mnAyuda.add(jmi_busca);
		
		jp_edicion = new JPanel();
		jp_edicion.setBounds(0, 21, 573, 50);
		panel.add(jp_edicion);
		jp_edicion.setLayout(null);
		
		jtoolBar = new JToolBar();
		jtoolBar.setVisible(false);
		jtoolBar.setBounds(0, 0, 397, 50);
		jp_edicion.add(jtoolBar);
		
		jbtn_Abrir = new JButton("");
		jtoolBar.add(jbtn_Abrir);
		jbtn_Abrir.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/open.png")));
		
		jbtn_guarda = new JButton("");
		jtoolBar.add(jbtn_guarda);
		jbtn_guarda.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/save.png")));
		
		jbtn_salir2 = new JButton("");
		jtoolBar.add(jbtn_salir2);
		jbtn_salir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jbtn_salir2.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/salir.png")));
		
		jbtn_imprime = new JButton("");
		jbtn_imprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	imprimirDatos(evt);
            }
        });
		jtoolBar.add(jbtn_imprime);
		jbtn_imprime.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/printer24x24.png")));
		
		jbtn_negrita = new JButton("");
		jtoolBar.add(jbtn_negrita);
		jbtn_negrita.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/negrita.png")));
		
		jbtn_italic = new JButton("");
		jtoolBar.add(jbtn_italic);
		jbtn_italic.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/italic.png")));
		
		jbtn_bolditalic = new JButton("");
		jtoolBar.add(jbtn_bolditalic);
		jbtn_bolditalic.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/sub.png")));
		
		jcbx_sizetexto = new JComboBox<String>();
		
		jcbx_sizetexto.addItem("15");
		jcbx_sizetexto.addItem("10");
		jcbx_sizetexto.addItem("20");
		jcbx_sizetexto.addItem("30");
		jcbx_sizetexto.addItem("40");
		jcbx_sizetexto.addItem("50");
		jcbx_sizetexto.addItem("Personalizar");
		jcbx_sizetexto.setToolTipText("Tama�o de fuente");
		jcbx_sizetexto.addItemListener(
			new ItemListener () {
				public void itemStateChanged(ItemEvent e) {

					int elegido;
					elegido=jcbx_sizetexto.getSelectedIndex();
					switch (elegido) {

						case 1:
							areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.ITALIC, 10);
							jta_textoedicion.setFont(areaFuente);
							break;

						case 2:
							areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.PLAIN, 20);
							jta_textoedicion.setFont(areaFuente);
							break;

						case 3:
							areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.PLAIN, 30);
							jta_textoedicion.setFont(areaFuente);
							break;

						case 4:
							areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.PLAIN, 40);
							jta_textoedicion.setFont(areaFuente);
							break;

						case 5:
							areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.PLAIN, 50);
							jta_textoedicion.setFont(areaFuente);
							break;
						case 6:
							size=Integer.parseInt(JOptionPane.showInputDialog("Digite el tama�o de la fuente"));
							areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.PLAIN, size);
							jta_textoedicion.setFont(areaFuente);
							break;
							
							default:
								
								break;
					}
				}
			}
		);
		jtoolBar.add(jcbx_sizetexto);
		jtoolBar.addSeparator();
		jcbx_tipofuente = new JComboBox<String>();
		jcbx_tipofuente.addItem("Nasalization");
		jcbx_tipofuente.addItem("Arial");
		jcbx_tipofuente.addItem("Mistral");
		jcbx_tipofuente.addItem("Calibri");
		jcbx_tipofuente.addItem("Algerian");
		jcbx_tipofuente.setToolTipText("Tipo de fuente ");
		jcbx_tipofuente.addItemListener(
			new ItemListener () {
				public void itemStateChanged(ItemEvent e) {

					int elegido;
					elegido=jcbx_tipofuente.getSelectedIndex();
					switch (elegido) {

						case 1:
							areaFuente= new Font("Arial", Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
							jta_textoedicion.setFont(areaFuente);
							break;

						case 2:
							areaFuente= new Font("Mistral", Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
							jta_textoedicion.setFont(areaFuente);
							break;

						case 3:
							areaFuente= new Font("calibri", Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
							jta_textoedicion.setFont(areaFuente);
							break;

						case 4:
							areaFuente= new Font("Algerian", Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
							jta_textoedicion.setFont(areaFuente);
							break;
							
							default:
								
								break;
					}
				}
			}
		);
		jcbx_tipofuente.setBounds(407, 0, 166, 24);
		jp_edicion.add(jcbx_tipofuente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 70, 424, 549);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 404, 527);
		panel_1.add(scrollPane);
		
		jta_textoedicion = new JTextArea();
		jta_textoedicion.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent arg0) {
				int vocales=0,palabras=0,num=0;
				int numero=0,total=0;
				numero=(jta_textoedicion.getText().length());
				int consonantes=0;
				
				String texto=jta_textoedicion.getText();
				
				String CadenaSinBlancos = "";
		
			StringTokenizer sts = new StringTokenizer(texto);
		
				for (int i = 0; i <numero; i++) {
					
					 if (texto.charAt(i) != ' '){
						
						 
						 CadenaSinBlancos += texto.charAt(i);
				      }
				
				}
				for (int j = 0; j < texto.length(); j++) {
					if ((texto.charAt(j)== 'a') ||(texto.charAt(j)== 'e') 
							||(texto.charAt(j)== 'i') ||(texto.charAt(j)== 'o') 
							||(texto.charAt(j)== 'u') ) {
						vocales++;
						
					}
					if ((texto.charAt(j)== '0') ||(texto.charAt(j)== '1') 
							||(texto.charAt(j)== '2') ||(texto.charAt(j)== '3') 
							||(texto.charAt(j)== '4') ||(texto.charAt(j)== '5') ||(texto.charAt(j)== '6')
							||(texto.charAt(j)== '7') ||(texto.charAt(j)== '8') ||(texto.charAt(j)== '9')
							) {
						num++;
						
					}
				}
				total=(CadenaSinBlancos.length()+1);
			consonantes=total-vocales;	
				jl_consonantes.setText(String.valueOf(consonantes-num));
				jl_letras.setText(String.valueOf(total-num));
				jl_palabras.setText(String.valueOf(sts.countTokens()));
				jl_numeros.setText(String.valueOf(num));
				jl_caracteres.setText(String.valueOf(total));
				
				
			}
		});
		jta_textoedicion.setFont(new Font("Nasalization", Font.PLAIN, 13));
		scrollPane.setViewportView(jta_textoedicion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 630, 620, 21);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblPalabras = new JLabel("Palabras:");
		lblPalabras.setBounds(0, 0, 78, 14);
		panel_2.add(lblPalabras);
		
		jl_palabras = new JLabel("");
		jl_palabras.setForeground(new Color(0, 128, 0));
		jl_palabras.setBounds(66, 0, 31, 14);
		panel_2.add(jl_palabras);
		
		jl_numeros = new JLabel("");
		jl_numeros.setForeground(new Color(0, 128, 0));
		jl_numeros.setBounds(301, 0, 31, 14);
		panel_2.add(jl_numeros);
		
		lblLetras = new JLabel("Letras:");
		lblLetras.setBounds(121, 0, 46, 14);
		panel_2.add(lblLetras);
		
		jl_letras = new JLabel("");
		jl_letras.setBounds(166, 0, 31, 14);
		panel_2.add(jl_letras);
		jl_letras.setForeground(new Color(0, 128, 0));
		
		lblNumeros = new JLabel("Numeros:");
		lblNumeros.setBounds(237, 0, 95, 14);
		panel_2.add(lblNumeros);
		
		lblConsonantes = new JLabel("Consonantes: ");
		lblConsonantes.setBounds(342, 0, 129, 14);
		panel_2.add(lblConsonantes);
		
		jl_consonantes = new JLabel("");
		jl_consonantes.setForeground(new Color(0, 128, 0));
		jl_consonantes.setBounds(444, 0, 31, 14);
		panel_2.add(jl_consonantes);
		
		lblCaracteres = new JLabel("Caracteres: ");
		lblCaracteres.setBounds(485, 0, 110, 14);
		panel_2.add(lblCaracteres);
		
		jl_caracteres = new JLabel("");
		jl_caracteres.setForeground(new Color(0, 128, 0));
		jl_caracteres.setBounds(564, 0, 46, 14);
		panel_2.add(jl_caracteres);
		
		panel_3 = new JPanel();
		panel_3.setBounds(461, 70, 169, 549);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		jcbx_filtro = new JComboBox();
		jcbx_filtro.setBounds(10, 0, 159, 20);
		jcbx_filtro.addItem("Filtros");
		jcbx_filtro.addItem("Palabras");
		jcbx_filtro.addItem("Numeros");
		jcbx_filtro.addItem("Letras");
		jcbx_filtro.addItem("Consonantes");
		jcbx_filtro.addItemListener(new ItemListener () {public void itemStateChanged(ItemEvent e) {

						int elegido;
						elegido=jcbx_filtro.getSelectedIndex();
						
									if (elegido==1) {
										System.out.println(elegido);
										System.out.println("entra a if");
										String palabra="",cual="";
										palabra=jta_textoedicion.getText();
										StringTokenizer strt= new StringTokenizer(palabra);
										
										
										while (strt.hasMoreElements()) {
											
											cual+= strt.nextToken()+"\n";
										}
										
										
										jta_muestrafiltro.setText(cual);
										areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
										jta_muestrafiltro.setFont(areaFuente);
									
									}
									if (elegido==2) {
										
										String texto="",guarda="";
										texto=jta_textoedicion.getText();
										
										for (int j = 0; j <texto.length(); j++) {
											
											if ((texto.charAt(j)== '0') ||(texto.charAt(j)== '1') 
							||(texto.charAt(j)== '2') ||(texto.charAt(j)== '3') 
							||(texto.charAt(j)== '4') ||(texto.charAt(j)== '5') ||(texto.charAt(j)== '6')
							||(texto.charAt(j)== '7') ||(texto.charAt(j)== '8') ||(texto.charAt(j)== '9')
							) {
											guarda+=String.valueOf(texto.charAt(j))+"\n"	;
											}
										}
										jta_muestrafiltro.setText(guarda);
										
									}
									if (elegido==3) {
										
										String letras=jta_textoedicion.getText();
										String guarda="";
										for (int j = 0; j < letras.length(); j++) {
											
											if (!((letras.charAt(j)== '0') ||(letras.charAt(j)== '1') 
													||(letras.charAt(j)== '2') ||(letras.charAt(j)== '3') 
													||(letras.charAt(j)== '4') ||(letras.charAt(j)== '5') ||(letras.charAt(j)== '6')
													||(letras.charAt(j)== '7') ||(letras.charAt(j)== '8') ||(letras.charAt(j)== '9')
													)) {
												guarda+=String.valueOf(letras.charAt(j))+"\n";	
																	
																	}
										}
										jta_muestrafiltro.setText(guarda);
										
									}
									if (elegido==4) {
										
										String texto= jta_textoedicion.getText();
										String muestra="";
										for (int j = 0; j < texto.length(); j++) {
											if (!((texto.charAt(j)== 'a') ||(texto.charAt(j)== 'e') 
							||(texto.charAt(j)== 'i') ||(texto.charAt(j)== 'o') 
							||(texto.charAt(j)== 'u')  ||((texto.charAt(j)== '0') ||(texto.charAt(j)== '1') 
									||(texto.charAt(j)== '2') ||(texto.charAt(j)== '3') 
									||(texto.charAt(j)== '4') ||(texto.charAt(j)== '5') ||(texto.charAt(j)== '6')
									||(texto.charAt(j)== '7') ||(texto.charAt(j)== '8') ||(texto.charAt(j)== '9')
									)) ) {
												muestra+=String.valueOf(texto.charAt(j))+"\n";
											}
											
										}
										jta_muestrafiltro.setText(muestra);
										
									}
									
										
									}
					
				}
			);
		panel_3.add(jcbx_filtro);
		
		jtf_busca = new JTextField();
		jtf_busca.setBounds(10, 31, 133, 20);
		panel_3.add(jtf_busca);
		jtf_busca.setColumns(10);
		
		jbtn_busca = new JButton("");
		jbtn_busca.setBounds(144, 26, 25, 25);
		panel_3.add(jbtn_busca);
		jbtn_busca.setIcon(new ImageIcon(Editor_texto.class.getResource("/Recursos/search.png")));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 54, 159, 484);
		panel_3.add(scrollPane_1);
		
		jta_muestrafiltro = new JTextArea();
		jta_muestrafiltro.setEditable(false);
		jta_muestrafiltro.setBackground(SystemColor.control);
		scrollPane_1.setViewportView(jta_muestrafiltro);
		
		jbtn_limpia = new JButton("");
		jbtn_limpia.setActionCommand("jbtn_limpia");
		jbtn_limpia.setBounds(0, 82, 24, 24);
		panel.add(jbtn_limpia);
		jbtn_Abrir.addActionListener(this);
		jbtn_guarda.addActionListener(this);
		jbtn_salir2.addActionListener(this);
		jbtn_negrita.addActionListener(this);
		jbtn_italic.addActionListener(this);
		jbtn_bolditalic.addActionListener(this);
		jbtn_limpia.addActionListener(this);
		jbtn_busca.addActionListener(this);
				
	}
	   private void imprimirDatos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
	         PaginationExample pagination = new PaginationExample();
	         pagination.imprimirnomina();
	    }//GEN-LAST:event_jBImprimirActionPerformed
	public void abrir () {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= fileChooser.showOpenDialog(this);
		if (result== JFileChooser.CANCEL_OPTION) return;
		File name= fileChooser.getSelectedFile();
		if(name.exists()) {
			if (name.isFile()) {
				try {
					BufferedReader input= new BufferedReader(new FileReader (name));
					StringBuffer buffer= new StringBuffer();
					String text;
					jta_textoedicion.setText("");
					while ((text=input.readLine()) !=null)
						buffer.append(text+ "\n");
					jta_textoedicion.append(buffer.toString());
				}
				catch (IOException ioException) {
					JOptionPane.showMessageDialog(null,"Error en el archivo", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (name.isDirectory ()) {
				String directory[] = name.list();
				jta_textoedicion.append("\n\nContenido del directorio:\n");
				for (int i=0;i<directory.length; i++)
					jta_textoedicion.append(directory [i]+"\n");
			}
			else {
				JOptionPane.showMessageDialog(null," No existe "," Error ",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void guardar () {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= fileChooser.showSaveDialog(this);
		if (result== JFileChooser.CANCEL_OPTION) return;
			File name= fileChooser.getSelectedFile();
			try {
				PrintWriter output= new PrintWriter(new FileWriter( name));
				output.write(jta_textoedicion.getText());
				output.close();
			}
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(null,"Error en el archivo","Error",JOptionPane.ERROR_MESSAGE);
			}
	}

	
	 public class PaginationExample implements Printable{
		    //Se obtienen las lineas de texto del JTextArea, la linea de texto finaliza cuando se encuentra el caracter de nueva linea \n
		    StringTokenizer lineasdetexto = new StringTokenizer(jta_textoedicion.getText(), "\n", true);
		    //Se obtiene el total de lineas de texto
		    int totallineas = lineasdetexto.countTokens();

		 int[] paginas;  // Arreglo de número de paginas que se necesitaran para imprimir todo el texto 

		 String[] textoLineas; //Lineas de texto que se imprimiran en cada hoja

		 //Metodo que se crea por default cuando una clase implementa a Printable
		 public int print(Graphics g, PageFormat pf, int pageIndex)
		          throws PrinterException {
		     //Se establece la fuente, el tipo, el tamaño, la metrica según la fuente asignada, 
		     //obtiene la altura de cada linea de texto para que todas queden iguales
		     Font font = new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
		     FontMetrics metrics = g.getFontMetrics(font);
		     int altodelinea = metrics.getHeight();
		     //Calcula el número de lineas por pagina y el total de paginas
		     if (paginas == null) {
		         initTextoLineas();
		         //Calcula las lineas que le caben a cada página dividiendo la altura imprimible entre la altura de la linea de texto
		         int lineasPorPagina = (int)(pf.getImageableHeight()/altodelinea);
		         //Calcula el numero de páginas dividiendo el total de lineas entre el numero de lineas por página
		         int numeroPaginas = (textoLineas.length-1)/lineasPorPagina;
		         paginas = new int[numeroPaginas];
		         for (int b=0; b<numeroPaginas; b++) {
		             paginas[b] = (b+1)*lineasPorPagina; 
		         }
		     }
		     //Si se recibe un indice de página mayor que el total de páginas calculadas entonces 
		     //retorna NO_SUCH_PAGE para indicar que tal pagina no existe 
		     if (pageIndex > paginas.length) {
		         return NO_SUCH_PAGE;
		     }
		     /*Por lo regular cuando dibujamos algun objeto lo coloca en la coordenada (0,0), esta coordenada 
		      * se encuentra fuera del área imprimible, por tal motivo se debe trasladar la posicion de las lineas de texto
		      * según el área imprimible del eje X y el eje Y 
		      */
		     
		     Graphics2D g2d = (Graphics2D)g;
		     g2d.translate(pf.getImageableX(), pf.getImageableY());
		     /*Dibujamos cada línea de texto en cada página,
		      * se aumenta a la posición 'y' la altura de la línea a cada línea de texto para evitar la saturación de texto 
		      */

		     int y = 0; 
		     int start = (pageIndex == 0) ? 0 : paginas[pageIndex-1];
		     int end   = (pageIndex == paginas.length) ? textoLineas.length : paginas[pageIndex];
		     for (int line=start; line<end; line++) {
		         y += altodelinea;
		         g.drawString(textoLineas[line], 0, y);
		     }
		     /* Retorna PAGE_EXISTS para indicar al invocador que esta página es parte del documento impreso
		      */
		     return PAGE_EXISTS;
		 }
		 
		  /* Agrega las lineas de texto al arreglo */
		 public void initTextoLineas() {
		     if (textoLineas == null) {
		         int numLineas=totallineas;
		         textoLineas = new String[numLineas];
		         //Se llena el arreglo que contiene todas las lineas de texto
		         while(lineasdetexto.hasMoreTokens()){
		         for (int i=0;i<numLineas;i++) {
		             textoLineas[i] = lineasdetexto.nextToken();
		         }
		         }
		     }
		 }
		 
		 //Este metodo crea un objeto Printerjob el cual es inicializado y asociado con la impresora por default
		 public void imprimirnomina() {
		      PrinterJob job = PrinterJob.getPrinterJob();
		      job.setPrintable(this);
		      //Si el usuario presiona imprimir en el dialogo de impresión, 
		      //entonces intenta imprimir todas las lineas de texto
		      boolean ok = job.printDialog();
		      if (ok) {
		          try {
		               job.print();
		          } catch (PrinterException ex) {
		           /* The job did not successfully complete */
		          }
		      }
		 }
		}
	
	  
	  
		public void actionPerformed(ActionEvent accion) {
			if (accion.getSource()==jbtn_Abrir) {
				abrir();
			}
			if (accion.getSource()==jbtn_guarda) {
				guardar();
			}
			if (accion.getSource()==jbtn_salir2) {
				guardar();
				System.exit(EXIT_ON_CLOSE);
			}
			
			if (accion.getSource()== jmi_nuevo) {
				
				jta_textoedicion.setText("");
			}
			
			if (accion.getSource()== jmi_abrir) {
				
				abrir();
			}
			if (accion.getSource()== jmi_guardar) {
				
			guardar();
			}
			if (accion.getSource()== jbtn_negrita) {
				areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.BOLD, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
				jta_textoedicion.setFont(areaFuente);
			}
			if (accion.getSource()== jbtn_italic) {
				areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(), Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
				jta_textoedicion.setFont(areaFuente);
			}
			if (accion.getSource()== jbtn_bolditalic) {
				areaFuente= new Font(jcbx_tipofuente.getSelectedItem().toString(),Font.BOLD | Font.ITALIC, Integer.parseInt(jcbx_sizetexto.getSelectedItem().toString()));
				jta_textoedicion.setFont(areaFuente);
			}
			
			if (accion.getSource()== jbtn_limpia) {
				areaFuente= new Font("Arial",Font.PLAIN, 18);
				jta_textoedicion.setFont(areaFuente);
			}
			if (accion.getSource()== jmi_salir) {
				
				guardar();
				System.exit(EXIT_ON_CLOSE);
			}
			if (accion.getSource()== jmi_actualiza) {
				carga c;
				try {
					c = new carga();
					c.setVisible(true);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			//mae esto hay que arreglarlo
			if (accion.getSource() == jbtn_busca) {
				String texto=jta_textoedicion.getText();
				String busqueda="ESTE CARACTER SE ENCUENTRA EN LAS POCICIONES: "+"\n";
				for (int i = 0; i < texto.length(); i++) {
					
					if (texto.contains(jtf_busca.getText())) {
						busqueda+=texto.charAt(i)+"\n";
					}
				}
				
				jta_muestrafiltro.setText(busqueda);
			}
			
			
			
		}
}
