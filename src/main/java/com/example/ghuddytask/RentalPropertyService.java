package com.example.ghuddytask;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("rentalPropertyService")
public class RentalPropertyService {
    private RentalPropertyRepository rentalPropertyRepository;

    public RentalPropertyService(RentalPropertyRepository rentalPropertyRepository){
        this.rentalPropertyRepository = rentalPropertyRepository;
    }
    public List<RentalProperty> getRentalProperties(){
        return rentalPropertyRepository.findAll();
    }

    public void upSertRentalProperty(RentalProperty rentalProperty){
        RentalProperty rp = rentalPropertyRepository.findRentalPropertyById(rentalProperty.getId());

        if (rp == null) {
            rp = new RentalProperty();
        }

        rp.setId(rentalProperty.getId());
        if(rentalProperty.getRentalPropertyName()!=null)
        rp.setRentalPropertyName(rentalProperty.getRentalPropertyName());
        if(rentalProperty.getLocation()!=null)
        rp.setLocation(rentalProperty.getLocation());
        rp.setCreatedAt(LocalDate.of(2000,1,1));
        rp.setLastUpdate(LocalDate.now());

        rentalPropertyRepository.save(rp);
    }

    public void deleteRentalProperty(RentalProperty rentalProperty) throws RuntimeException{
        RentalProperty rp = rentalPropertyRepository.findRentalPropertyById(rentalProperty.getId());
        if(rp==null){
            throw new RuntimeException("Entity Not Found!!");
        }
        else{
            rentalPropertyRepository.delete(rentalProperty);
        }
    }
}
