package com.example.activate;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Students {

    @Id
    private String id;
    private String firstName, lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favSubject;
    private BigDecimal totalSpent;
    private LocalDateTime created;

    public Students(String id, String firstName, String lastName, String email, Gender gender, Address address, List<String> favSubject, BigDecimal totalSpent, LocalDateTime created) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favSubject = favSubject;
        this.totalSpent = totalSpent;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getFavSubject() {
        return favSubject;
    }

    public void setFavSubject(List<String> favSubject) {
        this.favSubject = favSubject;
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(BigDecimal totalSpent) {
        this.totalSpent = totalSpent;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Students(String firstName, String lastName, String email, Gender gender, Address address, List<String> favSubject, BigDecimal totalSpent, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favSubject = favSubject;
        this.totalSpent = totalSpent;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", favSubject=" + favSubject +
                ", totalSpent=" + totalSpent +
                ", created=" + created +
                '}';
    }
}
