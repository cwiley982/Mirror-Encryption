package personal_projects.mirror_encryption.encryptor;

import java.util.Scanner;

import personal_projects.mirror_encryption.cursor.Cursor;
import personal_projects.mirror_encryption.point.Point;

public class Encryptor {

	public static void main(String[] args) {
		System.out.println("Enter the mirrors (in a 13 x 13 grid) and phrase to encrypt");
		Scanner input = new Scanner(System.in);
		Encryptor encryptor = new Encryptor(input);

		System.out.println(encryptor.encrypt());

	}

	private Point[][] grid;
	private Cursor[] cursors;
	private String wordToEncrypt;
	private Scanner input;

	public Encryptor(Scanner in) {
		grid = new Point[15][15];
		cursors = new Cursor[52]; // max possible cursors, one for each letter
									// of each case
		wordToEncrypt = "";
		input = in;
		setUpGridEdges();
	}

	private String encrypt() {
		processInput();
		return getEncryptedWord();
	}

	private String getEncryptedWord() {
		String encryptedWord = "";
		setUpCursors();
		for (int i = 0; i < cursors.length; i++) {
			while (!cursors[i].finished()) { // not on a letter yet
				cursors[i].move(); // move one in direction of cursor
			}
		}
		for (int i = 0; i < cursors.length; i++) {
			encryptedWord += grid[cursors[i].getRow()][cursors[i].getColumn()].getCharacter();
		}
		return encryptedWord;
	}

	private void setUpCursors() {
		int row;
		int col;
		for (int i = 0; i < wordToEncrypt.length(); i++) {
			row = findRowIndex(wordToEncrypt.substring(i, i + 1));
			col = findColumnIndex(wordToEncrypt.substring(i, i + 1));
			cursors[i] = new Cursor(row, col, grid);
		}
	}

	private int findColumnIndex(String letter) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (grid[0][j].getCharacter().equals(letter)) {
					return j;
				} else if (grid[14][j].getCharacter().equals(letter)) {
					return j;
				} else if (grid[i][0].getCharacter().equals(letter)) {
					return 0;
				} else if (grid[i][14].getCharacter().equals(letter)) {
					return 14;
				}
			}
		}
		return -1;
	}

	private int findRowIndex(String letter) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (grid[0][j].getCharacter().equals(letter)) {
					return 0;
				} else if (grid[14][j].getCharacter().equals(letter)) {
					return 14;
				} else if (grid[i][0].getCharacter().equals(letter)) {
					return i;
				} else if (grid[i][14].getCharacter().equals(letter)) {
					return i;
				}
			}
		}
		return -1;
	}

	private void processInput() {
		String line;
		int lineCount = 0;
		while (lineCount < 14) { // puts input into grid
			line = input.nextLine();
			if (lineCount != 13) {
				for (int i = 1; i < 14; i++) {
					grid[lineCount][i] = new Point(lineCount, i, line.substring(i));
				}
			} else {
				wordToEncrypt = line;
				input.close();
			}
			lineCount++;
		}
	}

	private String getWordToEncrypt() {
		return wordToEncrypt;
	}


	private void setUpGridEdges() {
		String[] firstRow = { " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", " " };
		String[] lastRow = { " ", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " " };
		for (int i = 0; i < 15; i++) {
			grid[0][i] = new Point(0, i, firstRow[i]);
			grid[14][i] = new Point(14, i, lastRow[i]);
			grid[i][0] = new Point(i, 0, firstRow[i].toUpperCase());
			grid[i][14] = new Point(i, 14, lastRow[i].toLowerCase());
		}
	}

}
