package liberman.lab6;

public class Cinema {
    private final int hallNumber;
    private final int row;
    private final int place;
    private final int[][][] cinemaArray;

    public Cinema(int hallNumber, int row, int place) {
        this.hallNumber = hallNumber;
        this.row = row;
        this.place = place;
        this.cinemaArray = new int[hallNumber][row][place];

        for (int i = 0; i < hallNumber; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < place; k++) {
                    cinemaArray[i][j][k] = 0;
                }
            }
        }
    }

    public int[][][] getCinemaArray() {
        return cinemaArray;
    }

    public int getRow() {
        return row;
    }

    public int getPlace() {
        return place;
    }
}
