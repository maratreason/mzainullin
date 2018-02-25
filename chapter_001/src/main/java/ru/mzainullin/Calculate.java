package ru.mzainullin;

/**
* Class Calculate решение задачи 001 
* @author zainullin
* @since 25.02.2018 
*/

public class Calculate {
	public String echo (String value) {
		return String.format("%s %s %s", value, value, value);
	}

/**
* Main method.
* @param args - args.
*/
	public static void main(String[] args) {
		Calculate calc = new Calculate();
		System.out.println(calc.echo("yeah"));
	}
}