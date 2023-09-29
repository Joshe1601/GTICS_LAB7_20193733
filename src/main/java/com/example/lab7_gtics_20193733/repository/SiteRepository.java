package com.example.lab7_gtics_20193733.repository;

import com.example.lab7_gtics_20193733.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer>{
}
