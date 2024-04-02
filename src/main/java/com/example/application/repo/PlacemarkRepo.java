package com.example.application.repo;

import com.example.application.entity.Placemark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacemarkRepo extends JpaRepository<Placemark, Long> {

}
