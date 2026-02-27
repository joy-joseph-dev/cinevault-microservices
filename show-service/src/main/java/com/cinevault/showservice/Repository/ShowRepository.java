package com.cinevault.showservice.Repository;
import com.cinevault.showservice.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}