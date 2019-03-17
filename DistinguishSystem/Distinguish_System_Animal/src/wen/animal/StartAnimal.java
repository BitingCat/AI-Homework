package wen.animal;

import java.awt.EventQueue;

public class StartAnimal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				GOAnimal go = new GOAnimal();
				go.GO();
			}
			
		});
	}
}
