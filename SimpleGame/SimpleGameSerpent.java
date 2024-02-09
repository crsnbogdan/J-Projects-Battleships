package SimpleGame;

public class SimpleGameSerpent {
    private int length;
    private int startIndex;
    private boolean[] serpentPositions;
    private boolean serpentSunk = false;

    public void summonSerpent(int serpentLength, int serpentStartIndex) {
        this.length = serpentLength;
        this.startIndex = serpentStartIndex;
        this.serpentPositions = new boolean[serpentLength];
        for (int i = 0; i < serpentLength; i++) {
            serpentPositions[i] = true; // True indicates an unsunken part of the serpent
        }
        System.out.println("A great sea serpent has been spotted in the ocean's depths. It spans " + serpentLength + " segments of the sea.");
    }

    public boolean strikeSerpent(int position) {
        if (position >= startIndex && position < startIndex + length) {
            serpentPositions[position - startIndex] = false; // Mark the segment as struck
            return true;
        }
        return false;
    }

    public boolean checkSerpent() {
        for (boolean segment : serpentPositions) {
            if (segment) {
                return false; // If any segment is true (unsunken), the serpent is not yet fully vanquished
            }
        }
        serpentSunk = true;
        return true; // The serpent is fully vanquished
    }
}
