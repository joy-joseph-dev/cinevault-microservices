package com.cinevault.theaterservice.Repository;

import com.cinevault.theaterservice.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}