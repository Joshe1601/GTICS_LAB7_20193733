package com.example.lab7_gtics_20193733.controller;

import com.example.lab7_gtics_20193733.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstatisticsController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping(value ="/estadisticas")
    public String principalSitios(Model model) {
        model.addAttribute("listaDevices", deviceRepository.getDevicesPerCountries());
        return "estadisticas";
    }
}
