public class Board {
	String marking;
	String[] feld;

	public Board() {
		feld = new String[9];
		System.out
				.println("Bitte ein X, oder ein O, sowie eine Zahl zwischen 1 und 3 fuer XY-Koordianten eingeben.");
	}

	public void setMark(String mark, int x, int y)
			throws InvalidPositionException {
		if (mark.equalsIgnoreCase("X") || mark.equalsIgnoreCase("O")) {
			if ((x >= 1 && x <= 3) && (y >= 1 && y <= 3)) {
				if (mark.equalsIgnoreCase("O")) {
					if (y == 1) {
						feld[x - 1] = "O";
						System.out.println(mark + " an " + x + ", " + y + " ("
								+ (x - 1) + ")");
					} else if (y == 2) {
						feld[x + y] = "O";
						System.out.println(mark + " an " + x + ", " + y + " ("
								+ (x + y) + ")");
					} else if (y == 3) {
						feld[x + y + 2] = "O";
						System.out.println(mark + " an " + x + ", " + y + " ("
								+ (x + y + 2) + ")");
					}
				}

				if (mark.equalsIgnoreCase("X")) {
					if (y == 1) {
						feld[x - 1] = "X";
						System.out.println(mark + " an " + x + ", " + y + " ("
								+ (x - 1) + ")");
					} else if (y == 2) {
						feld[x + y] = "X";
						System.out.println(mark + " an " + x + ", " + y + " ("
								+ (x + y) + ")");
					} else if (y == 3) {
						feld[x + y + 2] = "X";
						System.out.println(mark + " an " + x + ", " + y + " ("
								+ (x + y + 2) + ")");
					}
				}
			} else {
				throw new InvalidPositionException("Falsche Eingabe: " + x
						+ " oder " + y);
			}
		} else {
			throw new InvalidPositionException("Falsche Eingabe: " + mark);
		}
	}

	public boolean hasWinner(){
		Boolean winner = false;
		
		//Zeilen
		if (check(feld[0], feld[1], feld[2]) == true) {
			winner = true;
		}
		
		if (check(feld[3], feld[4], feld[5]) == true) {
			winner = true;
		}
		
		if (check(feld[6], feld[7], feld[8]) == true) {
			winner = true;
		}
		
		//Spalten
		if (check(feld[0], feld[1], feld[2]) == true) {
			winner = true;
		}
		
		if (check(feld[3], feld[4], feld[5]) == true) {
			winner = true;
		}
		
		if (check(feld[6], feld[7], feld[8]) == true) {
			winner = true;
		}
		
		//Diagonalen
		if (check(feld[0], feld[4], feld[8]) == true) {
			winner = true;
		}
		
		if (check(feld[3], feld[4], feld[5]) == true) {
			winner = true;
		}
		
		return winner;
	}
	
	private boolean check(String c1, String c2, String c3) {
		return ((c1 != null) && (c1.equalsIgnoreCase(c2)) && (c2.equalsIgnoreCase(c3)));
	}
}
