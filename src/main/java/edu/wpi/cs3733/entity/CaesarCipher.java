package edu.wpi.cs3733.entity;

/**
 * Caesar cipher; you must implement the cipher and the observer pattern
 */
public class CaesarCipher implements Observer {
	private String text;
	
	public CaesarCipher(Observable observable) {
		observable.register(this);
	}
	public void setText(String text){
		if(text.length() > 140) {
			this.text = "Input String Too Long";
			return;
		}
		String newString = "";
		for(char c: text.toCharArray()) {
			if (!Character.isLetter(c) && c != ' ') {
				this.text = "Invalid Input String";
				return;
			} else {
				if (c == ' ') {
					newString += ' ';
				}
				else if (Character.isUpperCase(c)) {
					newString += Character.toString((char) (((Character.toLowerCase(c) - 'a' + 1) % 26) + 'a')).toUpperCase();
				} else {
					newString += Character.toString((char) (((c - 'a' + 1) % 26) + 'a')).toLowerCase();
				}
			}
		}
		this.text = newString;
	}

	public String getText(){
		return this.text;
	}

	@Override
	public void notify(Object object){
		this.setText((String) object);
	}
}
