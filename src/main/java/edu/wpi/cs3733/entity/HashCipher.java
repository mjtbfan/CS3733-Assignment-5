package edu.wpi.cs3733.entity;

/**
 * Hash 'cipher'; you must implement the cipher (use String.hashCode()) and the observer pattern
 */
public class HashCipher implements Observer {
	private String text;
	
	public HashCipher(Observable observable)
	{
		observable.register(this);
	}
	
	public void setText(String text) {
		if (text.length() > 140) {
			this.text = "Input String Too Long";
			return;
		}
		for (char c : text.toLowerCase().toCharArray())
		{
			if (!Character.isLetter(c) && c != ' ')
			{
				this.text = "Invalid Input String";
				return;
			}
		}
		this.text = Integer.toString(text.hashCode());
	}
	
	
	public String getText() {
		return this.text;
	}
	
	@Override
	public void notify(Object object) {
		this.setText((String) object);
	}
	
}
