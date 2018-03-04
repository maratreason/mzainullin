package ru.mzainullin.loop;

/**
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class Board {

	/**
	* @method paint - рисуем шахматную доску.
	* @param width, height.
	* @return 
	*/
	public String paint(int width, int height) {

		StringBuilder str = new StringBuilder();
		String line = System.lineSeparator();

		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if ( ((i + j)%2 == 0) ) {
					if(width > 3 && height > 3) {
						str.append(" ");
					}
					str.append("X");
				} else {
					str.append(" ");
				}
			}

			str.append(line);
		}
		return str.toString();

	}


}