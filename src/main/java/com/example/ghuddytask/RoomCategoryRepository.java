package com.example.ghuddytask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory,Long> {
    RoomCategory findRoomCategoryById(Long id);
}
