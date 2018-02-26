
package ru.mzainullin;

/**
* Class Calculate решение задачи 001 
* @author zainullin
* @since 25.02.2018 
*/
public class Calculate {

	/**
	* Method echo
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo: " + name;
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