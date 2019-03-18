package edu.wpi.cs3733.entity;

/**
 * Elbonian cipher; you must implement the cipher and the observer pattern
 */
public class ElbonianCipher implements Observer
{
	private String text;
	
	public ElbonianCipher(Observable observable)
	{
		observable.register(this);
	}
	
	public void setText(String text) {
		if (text.length() > 140) {
			this.text = "Input String Too Long";
			return;
		}
		int temp;
		String newString = "";
		for (char c : text.toLowerCase().toCharArray()) {
			if (!Character.isLetter(c) && c != ' ') {
				this.text = "Invalid Input String";
				return;
			} else {
				if (c == ' ') {
					newString += "27";
				}
				else {
					temp = c - 'a' + 1;
					newString += Integer.toString(temp);
				}
			}
		}
		this.text = newString;
	}
	
	public String getText() {
		return this.text;
	}
	
	@Override
	public void notify(Object object) {
		this.setText((String) object);
	}
}
