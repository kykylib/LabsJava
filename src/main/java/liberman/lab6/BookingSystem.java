package liberman.lab6;

public class BookingSystem {
    private Cinema cinema;

    public BookingSystem(Cinema cinema) {
        this.cinema = cinema;
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        try {
            int[][][] cinemaArray = cinema.getCinemaArray();
            int[] arraySeats = cinemaArray[hallNumber - 1][row - 1];
            boolean isAccept = true;
            for (int i = 0; i < seats.length; i++) {
                int seat = seats[i];
                if (arraySeats[seat - 1] == 1) {
                    isAccept = false;
                    System.out.println("Sorry, current places is booked");
                    break;
                }
            }

            if (isAccept) {
                for (int i = 0; i < seats.length; i++) {
                    int seat = seats[i];
                    arraySeats[seat - 1] = 1;
                }
                System.out.println("You have booked places");
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Please, write correct data");
        }

    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        try {
            int[][][] cinemaArray = cinema.getCinemaArray();
            int[] arraySeats = cinemaArray[hallNumber - 1][row - 1];
            boolean isAccept = true;

            for (int i = 0; i < seats.length; i++) {
                int seat = seats[i];
                if (arraySeats[seat - 1] == 0) {
                    isAccept = false;
                    System.out.println("Sorry, this places already unbooked");
                    break;
                }
            }

            if (isAccept) {
                for (int i = 0; i < seats.length; i++) {
                    int seat = seats[i];
                    arraySeats[seat - 1] = 0;
                }
                System.out.println("You have unbooked places");
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Please, write correct data");
        }
    }

    public Boolean checkAvailability(int screen, int numSeats) {
        try {
            int[][][] cinemaArray = cinema.getCinemaArray();
            int[][] arraySeats = cinemaArray[screen - 1];
            int row = cinema.getRow();
            int place = cinema.getPlace();
            int counter = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < place; j++) {
                    if (arraySeats[i][j] == 1) {
                        counter = 0;
                        continue;
                    }
                    counter++;
                    if (counter == numSeats) {
                        System.out.println("This count is available");
                        return true;
                    }
                }
                counter = 0;
            }
            System.out.println("Have not available places");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Please, write correct data");
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        try {
            int[][][] cinemaArray = cinema.getCinemaArray();
            int[][] arraySeats = cinemaArray[hallNumber - 1];
            int row = cinema.getRow();
            int place = cinema.getPlace();
            int seatWidth = String.valueOf(place).length() + 2;

            System.out.print("       ");
            for (int j = 1; j <= place; j++) {
                System.out.printf("%" + seatWidth + "d", j);
            }
            System.out.println("\n");

            for (int i = 0; i < row; i++) {
                System.out.printf(" %-" + seatWidth + "d |", (i + 1));

                for (int j = 0; j < place; j++) {
                    System.out.printf("%" + seatWidth + "d", arraySeats[i][j]);
                }

                System.out.printf(" | %-" + seatWidth + "d\n", (i + 1));
            }

            System.out.print("\n       ");
            for (int j = 1; j <= place; j++) {
                System.out.printf("%" + seatWidth + "d", j);
            }
            System.out.println("\n");

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Please, write correct data");
        }
    }

    public int[][] findBestAvailable(int hallNumber, int numSeats) {
        try {
            int[][][] cinemaArray = cinema.getCinemaArray();
            int[][] arraySeats = cinemaArray[hallNumber - 1];
            int row = cinema.getRow();
            int place = cinema.getPlace();
            int counter = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < place; j++) {
                    if (arraySeats[i][j] == 1) {
                        counter = 0;
                        continue;
                    }
                    counter++;
                    if (counter == numSeats) {
                        return new int[][]{{i}, {j - (numSeats-1), j}};
                    }
                }
                counter = 0;
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Please, write correct data");
            return null;
        }
        System.out.println("Sorry, this count is not available");
        return null;
    }

    public void autoBook(int hallNumber, int numSeats) {
        int[][] bestAvailable = findBestAvailable(hallNumber,numSeats);
        int[] bestPlaces = bestAvailable[1];
        int capacity = bestPlaces[1] - bestPlaces[0] + 1;
        int[] places = new int[capacity];
        int index = 0;
        for (int i = bestPlaces[0]+1; i <= bestPlaces[1]+1; i++) {
            places[index] = i;
            index++;
        }
        bookSeats(hallNumber,bestAvailable[0][0]+1,places);
    }
}
