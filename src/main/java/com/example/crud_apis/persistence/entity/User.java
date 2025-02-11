package com.example.crud_apis.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "afm", unique = true)
    private String afm;

    @Basic(optional = false)
    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "mobile")
    private String mobile;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "is_enabled")
    private Boolean isEnabled;

    public User() {

    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "com.example.crud_apis.persistence.entity.User[ id=" + id + " ]";
    }
}
