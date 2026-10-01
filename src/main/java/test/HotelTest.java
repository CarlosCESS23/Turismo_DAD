package test;

import model.Hotel;
import servidor.helper.HotelServiceHelper;

import java.util.List;

public class HotelTest {
    public static void main(String[] args) {
        HotelServiceHelper hotelServiceHelper = new HotelServiceHelper();

        Hotel hotel = hotelServiceHelper.consultarHotel("Boa Vista");
        System.out.println(hotel);
    }
}
