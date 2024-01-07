package liberman.lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestBookingSystem {

    private Cinema cinema;
    private BookingSystem bookingSystem;

    @BeforeEach
    public void setUp() {
        cinema = new Cinema(5, 10, 20);
        bookingSystem = new BookingSystem(cinema);
    }

    @Test
    public void testBookSeats() {
        bookingSystem.bookSeats(1, 1, new int[]{1, 2, 3});
        int[][][] cinemaArray = cinema.getCinemaArray();
        int place1 = cinemaArray[0][0][0];
        int place2 = cinemaArray[0][0][1];
        int place3 = cinemaArray[0][0][2];
        assertEquals(1, place1);
        assertEquals(1, place2);
        assertEquals(1, place3);
    }

    @Test
    public void testCancelBooking() {
        bookingSystem.bookSeats(1, 1, new int[]{1, 2, 3});
        bookingSystem.cancelBooking(1, 1, new int[]{1, 2, 3});
        int[][][] cinemaArray = cinema.getCinemaArray();
        int place1 = cinemaArray[0][0][0];
        int place2 = cinemaArray[0][0][1];
        int place3 = cinemaArray[0][0][2];
        assertEquals(0, place1);
        assertEquals(0, place2);
        assertEquals(0, place3);
    }

    @Test
    public void testCheckAvailability() {
        for (int i = 1; i <= cinema.getRow(); i++) {
            bookingSystem.bookSeats(1, i, new int[]{1, 2, 3, 4, 5});
        }
        Boolean availability = bookingSystem.checkAvailability(1, 15);
        assertEquals(true, availability);
    }
    @Test
    public void testFindBestAvailable() {
        bookingSystem.bookSeats(1, 1, new int[]{1, 2, 3});
        int[][] bestAvailable = bookingSystem.findBestAvailable(1, 5);
        int indexFrom = bestAvailable[1][0];
        int indexTo = bestAvailable[1][1];
        assertEquals(3, indexFrom);
        assertEquals(7, indexTo);
    }
    @Test
    public void testAutoBook() {
        bookingSystem.bookSeats(1, 1, new int[]{1, 2, 3});
        bookingSystem.autoBook(1,3);
        int[][][] cinemaArray = cinema.getCinemaArray();
        int place1 = cinemaArray[0][0][3];
        int place2 = cinemaArray[0][0][4];
        int place3 = cinemaArray[0][0][5];
        assertEquals(1, place1);
        assertEquals(1, place2);
        assertEquals(1, place3);
    }

}
