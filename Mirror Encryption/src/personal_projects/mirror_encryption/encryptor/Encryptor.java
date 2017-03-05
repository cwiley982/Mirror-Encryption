package personal_projects.mirror_encryption.encryptor;

import java.util.Scanner;

public class Encryptor {

	public static void main(String[] args) {
		Encryptor encryptor = new Encryptor();
		Scanner input = new Scanner(System.in);
		String[][] inputArray = encryptor.processInput(input);
		String word = encryptor.findWord(inputArray[13]);

		System.out.println(encryptor.encrypt(inputArray, word));
	}

	public String[][] processInput(Scanner in) {
		String line;
		String[][] inputArray = new String[14][13];
		String[] currentLine;
		int lineCount = 0;
		while (in.hasNextLine()) { // puts input into an array
			line = in.nextLine();
			if (lineCount != 13) {
				currentLine = new String[13];
				for (int i = 0; i < 14; i++) {
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
		return inputArray;
	}

	public String findWord(String[] lastLine) {
		String word = "";
		for (int i = 0; i < lastLine.length; i++) {
			word += lastLine[i];
		}
		return word;
	}

	private String[][] mirrorArray;

	public Encryptor() {
		mirrorArray = new String[15][15];
		setUpEncryptionTable();
	}

	private void setUpEncryptionTable() {
		String[] firstRow = { " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", " " };
		String[] lastRow = { " ", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " " };
		mirrorArray[0] = firstRow;
		mirrorArray[14] = lastRow;
	}

	private String encrypt(String[][] inputArray, String word) {

		return "";
	}

}
