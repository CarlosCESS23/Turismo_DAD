package service;

import model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelService {

    List<Hotel> hoteis = new ArrayList<>();

    public void adicionar(Hotel hotel){
        this.hoteis.add(hotel);
    }

    public List<Hotel> getLista(){
        return this.hoteis;
    }

}