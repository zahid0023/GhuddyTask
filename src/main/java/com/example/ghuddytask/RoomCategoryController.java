package com.example.ghuddytask;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ghuddy/roomcategory")
public class RoomCategoryController {

    private RoomCategoryService roomCategoryService;

    public RoomCategoryController(RoomCategoryService roomCategoryService){
        this.roomCategoryService = roomCategoryService;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addRentalProperty(@RequestBody RoomCategory roomCategory){
        roomCategoryService.upSertRoomCategory(roomCategory);
        return new ResponseEntity<>("Added to database", HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoomCategory>> getRoomCategories(){
        List<RoomCategory> roomCategories = roomCategoryService.getRoomCategories();
        return new ResponseEntity<>(roomCategories,HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRoomCategory(@RequestBody RoomCategory roomCategory){
        roomCategoryService.upSertRoomCategory(roomCategory);
        return new ResponseEntity<>("Rental Entity Updated!",HttpStatus.OK);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProperty(@RequestBody RoomCategory roomCategory){
        try{
            roomCategoryService.deleteRoomCategory(roomCategory);
        }catch (RuntimeException ex){
            return new ResponseEntity<>("Room Category Not Found!!", HttpStatus.GONE);
        }
        return new ResponseEntity<>("Room Category Deleted!!", HttpStatus.OK);
    }
}
