package net.codejava.utils;

public class Color {
	public static final String reset = "\u001B[0m";
	public static final String green = "\u001B[32m";
	public static final String red = "\u001B[31m";
	
	public String reset() {
		return reset;
	}
	public String green() {
		return green;
	}
	public String red() {
		return red;
	}
}
