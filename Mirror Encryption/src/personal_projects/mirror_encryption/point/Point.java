package personal_projects.mirror_encryption.point;

import personal_projects.mirror_encryptor.mirror.Mirror;

public class Point {

	private int row;
	private int col;
	private String character;
	private Mirror mirror;

	public Point(int row, int col, String character) {
		this.row = row;
		this.col = col;
		this.character = character;
		mirror = null;
		if (hasMirror()) {
			setUpMirror();
		}
	}

	private void setUpMirror() {
		if (getCharacter().equals("\\")) {
			mirror = new Mirror("NESW", row, col);
		} else if (getCharacter().equals("/")) {
			mirror = new Mirror("NWSE", row, col);
		}
	}

	private boolean hasMirror() {
		if (character.equals("/") || character.equals("\\")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isEdge() {
		if (row == 0 || col == 0 || row == 14 || col == 14) {
			return true;
		} else {
			return false;
		}
	}

	private String getCharacter() {
		return character;
	}

	private Mirror getMirror() {
		return mirror;
	}

}
