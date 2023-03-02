package com.example.ghuddytask;

import jakarta.persistence.*;

@Entity
@Table(name = "room_category")
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Column(name="room_name")
    private String roomName;

    @Column(name = "price")
    private Double price;

    @Column(name = "no_of_rooms")
    private Integer noOfRooms;

    public RoomCategory(){

    }

    public RoomCategory(Long id, String roomName, Double price, Integer noOfRooms) {
        this.id = id;
        this.roomName = roomName;
        this.price = price;
        this.noOfRooms = noOfRooms;
    }

    public RoomCategory(String roomName, Double price, Integer noOfRooms) {
        this.roomName = roomName;
        this.price = price;
        this.noOfRooms = noOfRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
}
