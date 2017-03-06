package personal_projects.mirror_encryption.cursor;

public class Cursor {

	private String currentDirection;
	private int currentRow;
	private int currentCol;

	public Cursor(int row, int col) {
		currentRow = row;
		currentCol = col;
		setDirection();
	}

	private void setDirection() {
		if (currentRow == 0) {
			currentDirection = "down";
		} else if (currentRow == 12) {
			currentDirection = "up";
		} else if (currentCol == 0) {
			currentDirection = "right";
		} else if (currentCol == 12) {
			currentDirection = "left";
		}
	}

	private String getDirection() {
		return currentDirection;
	}

	private void changeDirection(String newDirection) {
		currentDirection = newDirection;
	}
}
