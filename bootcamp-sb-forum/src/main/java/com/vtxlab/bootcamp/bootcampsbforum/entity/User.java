package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity // An object that connected with db
@Table(name = "Users")
@Getter
@AllArgsConstructor
@Builder
public class User implements Serializable{

    @Id  //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto-Generated
    private Long id;

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @Column(name = "ADDRESS_LAT")
    private String addrLat;
    @Column(name = "ADDRESS_LNG")
    private String addrLong;
    @Column(name = "COMPANY_NAME")
    private String cName;
    @Column(name = "COMPANY_CATCHPHRASE")
    private String cCatchphrase;
    @Column(name = "COMPANY_BUSINESS_SCOPE")
    private String cBusinessScope;

}
