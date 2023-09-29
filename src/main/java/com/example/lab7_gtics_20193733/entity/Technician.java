package com.example.lab7_gtics_20193733.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianId", nullable = false)
    private Integer technicianid;

    @Column (name = "FirstName")
    private String firstname;

    @Column (name = "LastName")
    private String lastname;

    @Column (name = "Dni")
    private String dni;

    @Column (name = "Phone")
    private String phone;

    @Column (name = "Age")
    private Integer age;
}
