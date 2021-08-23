public class Persona {
	final private String Sexo_H = "H";
	
	private String Nombre = "";
	private int Edad = 0;
	private String Sexo = Sexo_H;
	private String NSS = "";
	private Double Peso = 0.0;
	private Double Altura = 0.0;
	
	
	Persona(String Nombre, int Edad,String Sexo, String NSS,Double Peso,Double Altura) {
		this.setNombre(Nombre);
		this.setEdad(Edad);
		this.setSexo(Sexo);
		this.setPeso(Peso);
		this.setAltura(Altura);		
		this.NSS = NSS;
	}
	
	Persona(){
		
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getNSS() {
		return NSS;
	}

	public Double getPeso() {
		return Peso;
	}

	public void setPeso(Double peso) {
		Peso = peso;
	}

	public Double getAltura() {
		return Altura;
	}

	public void setAltura(Double altura) {
		Altura = altura;
	}
	
	
}