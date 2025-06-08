package com.example.SpringFirstProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_USER7")
@NamedQueries({
        @NamedQuery(name = "User.selectUserByEmail", query = "from User u where u.email=:email"),
        @NamedQuery(name = "User.selectUserByPhone", query = "from User u where u.name =:phoneNumber")
})

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "userName")
    private String name;
    private String email;
    private String address;
    @Embedded
    private ContactDetails contactDetails;
    //@OneToMany
    //private ArrayList<Lending> lendings;




}
