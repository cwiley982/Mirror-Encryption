package personal_projects.mirror_encryptor.mirror;

public class Mirror {

	private String direction;
	private int row;
	private int col;

	public Mirror(String direction, int row, int column) {
		this.direction = direction;
		this.row = row;
		this.col = column;
	}

	private String getDirection() {
		return direction;
	}

	private int getRow() {
		return row;
	}

	private int getColumn() {
		return col;
	}
}
