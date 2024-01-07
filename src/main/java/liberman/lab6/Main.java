package liberman.lab6;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);
        BookingSystem bookingSystem = new BookingSystem(cinema);
        bookingSystem.bookSeats(1, 1, new int[]{1, 2});
//        bookingSystem.cancelBooking(1, 1, new int[]{1, 2});
        bookingSystem.checkAvailability(1, 20);
        bookingSystem.printSeatingArrangement(1);
        int[][] bestAvailable = bookingSystem.findBestAvailable(1, 2);
        bookingSystem.autoBook(1,2);
        System.out.println();
    }
}
