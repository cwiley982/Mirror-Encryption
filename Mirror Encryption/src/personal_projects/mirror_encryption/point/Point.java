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
		// if (getCharacter().equals("\\")) { //ascii 92
		// mirror = new Mirror("NESW", row, col);
		// } else if (getCharacter().equals("/")) { // ascii 47
		// mirror = new Mirror("NWSE", row, col);
		// }
		char character = getCharacter().charAt(0);
		if (character == 92) { // back slash
			mirror = new Mirror("NESW", row, col);
		} else if (character == 47) { // forward slash
			mirror = new Mirror("NWSE", row, col);
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

}
