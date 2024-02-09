package ComplexGame;

public class ComplexGameSerpent {
    private int length;
    private int row;
    private int startCol;
    private int endCol;
    private boolean[] serpentPositions = new boolean[length];
    private boolean serpentSunk = false;

    public void initializeSerpentPositions() {
         for (int i = 0; i < serpentPositions.length; i++) {
             serpentPositions[i] = true;
         }
     }

    public void setSerpentLength(int serpentLength) {
        this.length = serpentLength;
        this.serpentPositions = new boolean[serpentLength];
        initializeSerpentPositions();
    }

    public void hitSerpent(int hitPositionIndex) {
        if (hitPositionIndex >= 0 && hitPositionIndex < length) {
            serpentPositions[hitPositionIndex] = false;
        }
    }

    public int getSerpentLength () {
        return length;
    }

    public int getEndCol () {
        return endCol;
    }
    public int getStartCol () {
        return startCol;
    }

    public int getSerpentRow() {
        return row;
    }

    public void setSerpentPosition(int rowPos, int startColPos, int endColPos) {
        row = rowPos;
        startCol = startColPos;
        endCol = endColPos;
        System.out.println("A serpent of length " + length + " was created. it is positioned on row " + row + ", starts starts on the column " + startCol + ", and ends on the column " +endCol +".");
    }

    public boolean checkSerpentSunkStatus() {
        for (boolean segment : serpentPositions) {
            if (segment) {
                return false; // If any segment is true (unsunken), the serpent is not yet fully vanquished
            }
        }
        serpentSunk = true;

        return true; // The serpent is fully vanquished
    }
}
