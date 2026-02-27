package com.cinevault.theaterservice.Repository;
import com.cinevault.theaterservice.Entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
}