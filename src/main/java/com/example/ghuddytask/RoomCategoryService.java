package com.example.ghuddytask;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("roomCategoryService")
public class RoomCategoryService {
    private RoomCategoryRepository roomCategoryRepository;

    public RoomCategoryService(RoomCategoryRepository roomCategoryRepository){
        this.roomCategoryRepository = roomCategoryRepository;
    }

    public void upSertRoomCategory(RoomCategory roomCategory){
        RoomCategory rc = roomCategoryRepository.findRoomCategoryById(roomCategory.getId());
        if (rc == null){
            rc = new RoomCategory();
        }
        rc.setId(roomCategory.getId());
        if(roomCategory.getRoomName()!=null)
        rc.setRoomName(roomCategory.getRoomName());
        if(roomCategory.getNoOfRooms()!=null)
        rc.setNoOfRooms(roomCategory.getNoOfRooms());
        if(roomCategory.getPrice()!=null)
        rc.setPrice(roomCategory.getPrice());
        roomCategoryRepository.save(rc);
    }

    public List<RoomCategory> getRoomCategories() {
        List<RoomCategory> roomCategories = roomCategoryRepository.findAll();
        return roomCategories;
    }

    public void deleteRoomCategory(RoomCategory roomCategory) throws RuntimeException{
        if((roomCategoryRepository.findRoomCategoryById(roomCategory.getId()))==null){
            throw new RuntimeException("Rental Property not found!!");
        }else{
            roomCategoryRepository.delete(roomCategory);
        }
    }

}
