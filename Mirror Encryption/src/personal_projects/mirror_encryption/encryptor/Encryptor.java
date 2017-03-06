package personal_projects.mirror_encryption.encryptor;

import java.util.Scanner;

import personal_projects.mirror_encryptor.mirror.Mirror;

public class Encryptor {

	public static void main(String[] args) {

		// for (int i = 0; i < 15; i++) { // prints reference array
		// for (int j = 0; j < 15; j++) {
		// System.out.print(array[i][j]);
		// }
		// System.out.println();
		// }

		System.out.println("Enter the mirrors (in a 13 x 13 grid) and phrase to encrypt");
		Scanner input = new Scanner(System.in);
		Encryptor encryptor = new Encryptor(input);

		System.out.println(encryptor.encrypt());

	}

	private String[][] encryptionTable;
	private String[][] inputArray;
	private Mirror[] mirrors;
	private String wordToEncrypt;
	private Scanner input;

	public Encryptor(Scanner in) {
		encryptionTable = new String[15][15];
		inputArray = new String[14][13];
		mirrors = new Mirror[169]; // max possible mirrors in a 13x13 array
		wordToEncrypt = "";
		input = in;
		setUpEncryptionTable();
	}

	private String encrypt() {
		processInput();
		setUpMirrors();
		getWordToEncrypt(inputArray[13]);
		String encryptedWord = "";
		return encryptedWord;
	}

	private void processInput() {
		String line;
		String[] currentLine;
		int lineCount = 0;
		while (input.hasNextLine()) { // puts input into an array
			line = input.nextLine();
			if (lineCount != 13) {
				currentLine = new String[13];
				for (int i = 0; i < 13; i++) {
					currentLine[i] = line.substring(i, i + 1);
				}
				inputArray[lineCount] = currentLine;
				lineCount++;
			} else {
				currentLine = new String[13];
				for (int i = 0; i < line.length(); i++) {
					currentLine[i] = line.substring(i, i + 1);
				}
			}
		}
	}

	private void getWordToEncrypt(String[] lastLine) {
		for (int i = 0; i < lastLine.length; i++) {
			wordToEncrypt += lastLine[i];
		}
	}

	private Mirror[] setUpMirrors() {
		int k = 0;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				if (inputArray[i][j].equals("\\")) {
					mirrors[k] = new Mirror("NESW", i + 1, j + 1);
					k++;
				} else if (inputArray[i][j].equals("/")) {
					mirrors[k] = new Mirror("NWSE", i + 1, j + 1);
					k++;
				}
			}
		}

		return mirrors;
	}

	private void setUpEncryptionTable() {
		String[] firstRow = { " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", " " };
		String[] lastRow = { " ", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " " };
		encryptionTable[0] = firstRow;
		encryptionTable[14] = lastRow;
		for (int i = 1; i < 14; i++) {
			encryptionTable[i][0] = firstRow[i].toUpperCase();
			encryptionTable[i][14] = lastRow[i].toLowerCase();
			for (int j = 1; j < 14; j++) {
				encryptionTable[i][j] = " ";
			}
		}
	}

}
