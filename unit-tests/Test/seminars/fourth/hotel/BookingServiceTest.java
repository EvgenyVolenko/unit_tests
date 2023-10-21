package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Test
    void bookingTestPositive() {

        int roomId = 16;
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(roomId)).thenReturn(true);

        boolean check = bookingService.bookRoom(roomId);

        verify(hotelService, times(1)).isRoomAvailable(roomId);
        assertTrue(check);
    }

    @Test
    void bookingTestNegative() {

        int roomId = 15;
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(roomId)).thenReturn(true);

        boolean check = bookingService.bookRoom(roomId);

        verify(hotelService, times(1)).isRoomAvailable(roomId);
        assertTrue(check);
    }
}