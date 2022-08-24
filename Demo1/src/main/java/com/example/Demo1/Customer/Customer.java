package com.example.Demo1.Customer;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )


    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator =  "customer_sequence"
    )


    private Long id;
    private  String name;
    private String email;
    private LocalDate Dob;

    @Transient
    private  Integer age;

    public Customer() {

    }

    public Customer(Long id, String name,

                    String email,
                    LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        Dob = dob;
    }

    public Customer(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        Dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }


    public Integer getAge() {
        return Period.between(this.Dob,LocalDate.now()).getDays();    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Dob=" + Dob +
                '}';
    }
}
