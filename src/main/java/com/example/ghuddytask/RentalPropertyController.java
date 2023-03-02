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
@RequestMapping(value = "/api/ghuddy/rentalproperty")
public class RentalPropertyController {

    private RentalPropertyService rentalPropertyService;

    public RentalPropertyController(RentalPropertyService rentalPropertyService){
        this.rentalPropertyService = rentalPropertyService;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addRentalProperty(@RequestBody RentalProperty rentalProperty){
        rentalPropertyService.upSertRentalProperty(rentalProperty);
        return new ResponseEntity<>("Added to database", HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RentalProperty>> getProperties(){
        List<RentalProperty> rentalProperties = rentalPropertyService.getRentalProperties();
        return new ResponseEntity<>(rentalProperties,HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProperty(@RequestBody RentalProperty rentalProperty){
        rentalPropertyService.upSertRentalProperty(rentalProperty);
        return new ResponseEntity<>("Rental Entity Updated!",HttpStatus.OK);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProperty(@RequestBody RentalProperty rentalProperty){
        try{
            rentalPropertyService.deleteRentalProperty(rentalProperty);
        }catch (RuntimeException ex){
            return new ResponseEntity<>("Rental Property Not Found!!", HttpStatus.GONE);
        }
        return new ResponseEntity<>("Rental Property Deleted!!", HttpStatus.OK);
    }
}
