import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class PersonaGui {

	private JFrame frame;
	private JTextField txt_Persona_Nombre;
	private JTextField txt_Persona_Edad;
	private JTextField txt_Persona_Peso;
	private JTextField txt_Persona_Altura;
	private Tools to = new Tools();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					PersonaGui window = new PersonaGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonaGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 78, 24);			    		
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 34, 78, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 57, 78, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Peso (kg.)");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 81, 78, 24);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Altura (m.)");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 107, 78, 24);
		frame.getContentPane().add(lblNewLabel_5);
		
		txt_Persona_Nombre = new JTextField();
		txt_Persona_Nombre.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_Persona_Nombre.setBounds(87, 10, 200, 24);			
	    txt_Persona_Nombre.addKeyListener(to.SoloLetras());		
		frame.getContentPane().add(txt_Persona_Nombre);
		txt_Persona_Nombre.setColumns(10);
		
		txt_Persona_Edad = new JTextField();
		txt_Persona_Edad.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_Persona_Edad.setColumns(10);
		txt_Persona_Edad.setBounds(87, 34, 96, 24);
		txt_Persona_Edad.addKeyListener(to.SoloNumeros());
		frame.getContentPane().add(txt_Persona_Edad);
		
		txt_Persona_Peso = new JTextField();
		txt_Persona_Peso.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_Persona_Peso.setColumns(10);
		txt_Persona_Peso.setBounds(87, 83, 96, 24);
		txt_Persona_Peso.addKeyListener(to.NumerosUnDecimal(txt_Persona_Peso));
		frame.getContentPane().add(txt_Persona_Peso);
		
		txt_Persona_Altura = new JTextField();
		txt_Persona_Altura.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_Persona_Altura.setColumns(10);
		txt_Persona_Altura.setBounds(87, 107, 96, 24);
		txt_Persona_Altura.addKeyListener(to.NumerosUnDecimal(txt_Persona_Altura));
		frame.getContentPane().add(txt_Persona_Altura);
		
		JRadioButton cb_Persona_H = new JRadioButton("Hombre");
		cb_Persona_H.setFont(new Font("Arial", Font.PLAIN, 12));
		cb_Persona_H.setBounds(87, 61, 78, 21);
		cb_Persona_H.setSelected(true);
		frame.getContentPane().add(cb_Persona_H);
		
		JRadioButton cb_Persona_M = new JRadioButton("Mujer");
		cb_Persona_M.setFont(new Font("Arial", Font.PLAIN, 12));
		cb_Persona_M.setBounds(180, 61, 66, 21);
		frame.getContentPane().add(cb_Persona_M);
		
		ButtonGroup group = new ButtonGroup();
		group.add(cb_Persona_M);
		group.add(cb_Persona_H);
		
		JTextPane txt_Persona_Datos = new JTextPane();
		txt_Persona_Datos.setBounds(10, 193, 251, 188);
		frame.getContentPane().add(txt_Persona_Datos);
		
		JButton btn_Persona_calculaimc = new JButton("Validar");
		btn_Persona_calculaimc.setFont(new Font("Arial", Font.BOLD, 12));
		btn_Persona_calculaimc.setBounds(29, 154, 110, 29);
		btn_Persona_calculaimc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ValidaCamposPersona()) {
					String SexoPersona = "";
					if(cb_Persona_H.isSelected())
						SexoPersona = "H";
					else
						SexoPersona = "M";								
					
					Persona persona = new Persona(txt_Persona_Nombre.getText(), Integer.parseInt(txt_Persona_Edad.getText()), SexoPersona,generaNSS(), Double.parseDouble(txt_Persona_Peso.getText()), Double.parseDouble(txt_Persona_Altura.getText()));
					int imcPersona = CalculaImc(persona.getSexo(), persona.getPeso(), persona.getAltura());
					String mayorEdad = esMayorDeEdad(persona.getEdad()) == true?"Si":"No";
					
					
					txt_Persona_Datos.setText("Mayor de Edad: " + mayorEdad + "\n" +
							"IMC: " + imcPersona + "  " + imc_Detail(imcPersona) + "\n\n" +
							Persona_toString(persona)
							);
										
				}
				else {
					JOptionPane.showMessageDialog(null, "Se requiern todos los campos");
				}
			}
		});				
		
		
		frame.getContentPane().add(btn_Persona_calculaimc);									
	}
	
	public boolean ValidaCamposPersona() {
		int numerrors = 0;
		if(txt_Persona_Nombre.getText().isEmpty())
			numerrors++;
		
		if(txt_Persona_Edad.getText().isEmpty())
			numerrors++;
		
		if(txt_Persona_Peso.getText().isEmpty())
			numerrors++;
		
		if(txt_Persona_Altura.getText().isEmpty())
			numerrors++;
		
		if(numerrors == 0)
			return true;
		else
			return false;
	}
	
	public boolean ValidaCamposPersonaIMC() {
		int numerrors = 0;	
		
		if(txt_Persona_Peso.getText().isEmpty())
			numerrors++;
		
		if(txt_Persona_Altura.getText().isEmpty())
			numerrors++;
		
		if(numerrors == 0)
			return true;
		else
			return false;
	}

	public int CalculaImc(String Sexo, Double Peso, Double Altura) {		
		Double Imc = Peso/(Altura * Altura);
		int imcIndice = 0;
		if(Sexo == "H") {
			if(Imc < 20.0)
				imcIndice = -1;
			if(Imc > 20.0  && Imc < 25.0)
				imcIndice = 0;
			if(Imc > 25.0)
				imcIndice = 1;
		}
		else {
			if(Imc < 19.0)
				imcIndice = -1;
			if(Imc > 19.0  && Imc < 24.0)
				imcIndice = 0;
			if(Imc > 24.0)
				imcIndice = 1;
		}	
		
		System.out.println("sexo " + Sexo + " imc " + Imc + " indice " + imcIndice);
			
		return imcIndice;
	}
	
	public String imc_Detail(int imcVal) {
		String ImcDetail = "";
		switch (imcVal) {
		case -1:
			ImcDetail = "Falta de peso";
			break;
		case 0:
			ImcDetail = "Peso normal";		
			break;
		case 1:
			ImcDetail = "Sobrepeso";
			break;
		}
		
		return ImcDetail;
	}
	
	public boolean esMayorDeEdad(int edad) {
		if(edad >= 18)
			return true;
		else
			return false;
	}
	
	public String generaNSS() {
		int leftLimit = 48;
	    int rightLimit = 122;
	    int targetStringLength = 8;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
		return generatedString.toUpperCase();
	}
	
	public String Persona_toString(Persona per) {
		String dataPersona =  "Nombre: " + per.getNombre() + "\n"+
				"Edad: " + per.getEdad() + " Años \n"+
				"Sexo: " + per.getSexo() + "\n"+
				"NSS: " + per.getNSS() + "\n"+
				"Peso: " + per.getPeso() + " Kg\n"+
				"Altura: " + per.getAltura() + " m.\n";
		
		return dataPersona;
	}
}
