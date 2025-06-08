package com.example.SpringFirstProject.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContactDetails {

   // private String address;
    private String city;
    private String phoneNumber;
}
