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
		if (isMirror()) {
			setUpMirror();
		}
	}

	private void setUpMirror() {
		char character = getCharacter().charAt(0);
		if (character == 92) { // back slash
			mirror = new Mirror("back", row, col);
		} else if (character == 47) { // forward slash
			mirror = new Mirror("forward", row, col);
		}
	}

	public boolean hasMirror() {
		if (mirror != null) {
			return true;
		}
		return false;
	}

	public boolean isEdge() {
		if (row == 0 || col == 0 || row == 14 || col == 14) {
			return true;
		} else {
			return false;
		}
	}

	public String getCharacter() {
		return character;
	}

	public Mirror getMirror() {
		return mirror;
	}

	public boolean isMirror() {
		if (row != 0 && row != 14 && col != 0 && col != 14) {
			if (character.charAt(0) == 92 || character.charAt(0) == 47) {
				return true;
			} else if (Character.isWhitespace(character.charAt(0))) {
				return false;
			} else {
				throw new IllegalArgumentException("Invalid mirror setup - must only use spaces and slashes");
			}
		} else {
			return false;
		}
	}

}
