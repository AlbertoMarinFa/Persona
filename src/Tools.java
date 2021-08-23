import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class Tools {
	public KeyListener SoloLetras() {
		KeyListener keyListener = new KeyListener() {
	        public void keyPressed(KeyEvent keyEvent) {}

	        public void keyReleased(KeyEvent keyEvent) {}

	        @SuppressWarnings("deprecation")
			public void keyTyped(KeyEvent keyEvent) {
	          char car = keyEvent.getKeyChar();
	          if(Character.isLetter(car) || Character.isSpace(car)){

	          }else{
	        	  keyEvent.consume();
	          }
	        }
	      };
	      
	      return keyListener;
	}
	
	public KeyListener SoloNumeros() {
		KeyListener keyListener = new KeyListener() {
	        public void keyPressed(KeyEvent keyEvent) {}

	        public void keyReleased(KeyEvent keyEvent) {}

	        public void keyTyped(KeyEvent keyEvent) {
	          char car = keyEvent.getKeyChar();
	          if(Character.isDigit(car)){

	          }else{
	        	  keyEvent.consume();
	          }
	        }
	      };
	      
	      return keyListener;
	}
	
	public KeyListener NumerosUnDecimal(JTextField text) {
		KeyListener keyListener = new KeyListener() {
	        public void keyPressed(KeyEvent keyEvent) {}

	        public void keyReleased(KeyEvent keyEvent) {}

	        public void keyTyped(KeyEvent keyEvent) {
	        	char caracter = keyEvent.getKeyChar();
	        	String textoGet = text.getText();
	        	
	        	if(textoGet.contains(".") && caracter == '.') {	        		
	        		keyEvent.consume();	
	        	}                	
	        		        	
                if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter !='.')){		                	
                	keyEvent.consume();
                }
	        }
	      };
	      
	      return keyListener;
	}
}
