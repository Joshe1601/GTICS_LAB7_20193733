package com.example.lab7_gtics_20193733.controller;

import com.example.lab7_gtics_20193733.entity.Technician;
import com.example.lab7_gtics_20193733.repository.DeviceRepository;
import com.example.lab7_gtics_20193733.repository.LocationRepository;
import com.example.lab7_gtics_20193733.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class TecnicosController {
    @Autowired
    private TechnicianRepository technicianRepository;



    @GetMapping(value ="/")
    public String defaultPage() {
        return "index";
    }

    @GetMapping(value ="/tecnicos")
    public String principalSitios(Model model) {
        List<Technician> listaTecnicos = technicianRepository.findAll();
        model.addAttribute("listaTecnicos", listaTecnicos);
        return "lista-tecnicos";
    }

    @GetMapping(value ="/tecnicos/nuevo")
    public String nuevoSitio(RedirectAttributes attr, @ModelAttribute("technician") Technician technician) {
        return "nuevo-tecnico";
    }

    @GetMapping(value ="/tecnicos/editar/{id}")
    public String editarSitio(Model model, @ModelAttribute("technician") Technician technician, @PathVariable Integer id, RedirectAttributes attr) {
        Optional<Technician> optionalTechnician = technicianRepository.findById(id);
        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("technician", technician);
            return "nuevo-tecnico";
        } else {
            attr.addFlashAttribute("msg", "El técnico no existe");
            return "redirect:/tecnicos";
        }
    }

    @PostMapping(value ="/tecnicos/guardar")
    public String guardarSitio(@ModelAttribute("technician") Technician technician, RedirectAttributes attr) {

        if(technician.getTechnicianid() == null){
            attr.addFlashAttribute("msg", "Técnico " + technician.getFirstname() + " " + technician.getLastname() + " creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Técnico "  + technician.getFirstname() + " " + technician.getLastname() + " actualizado exitosamente");
        }
        technicianRepository.save(technician);

        return "redirect:/tecnicos";
    }

}
