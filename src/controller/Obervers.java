package controller;

import vue.test;

public class Obervers {
	
	test stats;
	
	public Obervers(test stat) {
		this.stats = stat;
	}
	
	public void suppressionDuFiltre() {
		this.stats.suppressionFiltre();
	}
}
