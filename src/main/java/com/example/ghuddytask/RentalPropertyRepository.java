package com.example.ghuddytask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalPropertyRepository extends JpaRepository<RentalProperty,Long> {
    RentalProperty findRentalPropertyById(Long id);

}
