package ru.iselldonuts.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.iselldonuts.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class PlaceCreationRequest {
    private String address;

    public PlaceCreationRequest() {
    }

    public PlaceCreationRequest(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}