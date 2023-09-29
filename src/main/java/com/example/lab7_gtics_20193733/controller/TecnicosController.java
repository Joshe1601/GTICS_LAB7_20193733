package com.example.lab7_gtics_20193733.controller;

import com.example.lab7_gtics_20193733.repository.LocationRepository;
import com.example.lab7_gtics_20193733.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TecnicosController {
    @Autowired
    private TechnicianRepository siteRepository;

    @Autowired
    private LocationRepository locationRepository;


    @GetMapping(value ="/")
    public String defaultPage() {
        return "index";
    }

    @GetMapping(value ="/tecnicos")
    public String principalSitios(Model model) {

        return "lista-tecnicos";
    }
}
