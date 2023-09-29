package com.example.lab7_gtics_20193733.repository;

import com.example.lab7_gtics_20193733.dto.DevicesPerCountriesDto;
import com.example.lab7_gtics_20193733.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query(value = "SELECT Country, count(*) FROM location INNER JOIN site ON location.LocationID = site.LocationID INNER JOIN device On site.SiteID = device.SiteID GROUP BY Country", nativeQuery = true)
    List<DevicesPerCountriesDto> getDevicesPerCountries();
}
