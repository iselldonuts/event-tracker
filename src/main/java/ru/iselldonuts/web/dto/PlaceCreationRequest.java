package ru.iselldonuts.web.dto;

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
