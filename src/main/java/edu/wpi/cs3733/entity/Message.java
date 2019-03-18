package edu.wpi.cs3733.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * Message class to hold clear text; you must implement the rest of the class
 */
public class Message implements Observable {
	private List<Observer> observers = new ArrayList<>();
	private String input;
	
	public void setText(String text){
		this.input = text;
		notifyObservers();
	}

	public String getText(){
		return null;
	}

	@Override
	public void register(Observer o){
		observers.add(o);
	}

	@Override
	public void notifyObservers(){
		for(Observer i: observers) {
			i.notify(this.input);
		}
	}
}
