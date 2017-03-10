package personal_projects.mirror_encryption.cursor;

import personal_projects.mirror_encryption.point.Point;

public class Cursor {

	private String currentDirection;
	private int currentRow;
	private int currentCol;
	private boolean finished;
	private boolean isWhiteSpace;
	private Point[][] grid;

	public Cursor(int row, int col, Point[][] grid) {
		setRow(row);
		setColumn(col);
		this.grid = grid;
		checkForSpace();
		setInitialDirection();
		finished = false;
	}

	private void checkForSpace() {
		if (grid[currentRow][currentCol].getCharacter().equals(" ")) {
			isWhiteSpace = true;
		} else {
			isWhiteSpace = false;
		}
	}

	private void setInitialDirection() {
		if (currentRow == 0) {
			currentDirection = "down";
		} else if (currentRow == 14) {
			currentDirection = "up";
		} else if (currentCol == 0) {
			currentDirection = "right";
		} else if (currentCol == 14) {
			currentDirection = "left";
		}
	}

	private void setRow(int newRow) {
		currentRow = newRow;
	}

	private void setColumn(int newColumn) {
		currentCol = newColumn;
	}

	public int getRow() {
		return currentRow;
	}

	public int getColumn() {
		return currentCol;
	}

	public String getDirection() {
		return currentDirection;
	}

	public String getCharacter() {
		return grid[currentRow][currentCol].getCharacter();
	}
	private void changeDirection(String newDirection) {
		currentDirection = newDirection;
	}

	public boolean finished() {
		return finished;
	}

	public void move() {
		if (isWhiteSpace) {
			finished = true;
		} else if (getDirection().equals("up")) { // move 1
			setRow(currentRow - 1);
		} else if (getDirection().equals("down")) {
			setRow(currentRow + 1);
		} else if (getDirection().equals("left")) {
			setColumn(currentCol - 1);
		} else if (getDirection().equals("right")) {
			setColumn(currentCol + 1);
		}
		if (currentRow == 0 || currentCol == 0 || currentRow == 14 || currentCol == 14) {
			finished = true;
		}
		if (grid[currentRow][currentCol].hasMirror()) {
			boolean forwardSlash = false;
			if (grid[currentRow][currentCol].getMirror().getDirection().equals("NWSE")) {
				forwardSlash = true;
			}
			if (currentDirection.equals("up")) {
				if (forwardSlash) {
					changeDirection("right");
				} else {
					changeDirection("left");
				}
			} else if (currentDirection.equals("down")) {
				if (forwardSlash) {
					changeDirection("left");
				} else {
					changeDirection("right");
				}
			} else if (currentDirection.equals("left")) {
				if (forwardSlash) {
					changeDirection("up");
				} else {
					changeDirection("down");
				}
			} else if (currentDirection.equals("right")) {
				if (forwardSlash) {
					changeDirection("down");
				} else {
					changeDirection("up");
				}
			}

		}
	}
}
