package ru.mzainullin.loop;

/**
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class Board {

	/**
	* @param width = ширина.
	* @param height = высота.
	* @return str = результат.
	*/
	public String paint(int width, int height) {

		StringBuilder str = new StringBuilder();
		String line = System.lineSeparator();

		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (((i + j) % 2 == 0)) {
					str.append("X");
				} else {
					if (width > 3 || height > 3) {
						str.append("  ");
					} else {
						str.append(" ");
					}

				}
			}

			str.append(line);
		}
		return str.toString();
	}

}