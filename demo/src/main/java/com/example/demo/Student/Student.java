package com.example.demo.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id ;
    private String nom ;
    private String email ;
    private LocalDate dateDeNaissance;
    @Transient
    private Integer age ;

    public Student() {
    }

    public Student(String nom,
                   String email,
                   LocalDate dateDeNaissance) {
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;

    }

    public Student(Long id,
                   String nom,
                   String email,
                   LocalDate dateDeNaissance) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Integer getAge() {
        return Period.between(this.dateDeNaissance,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", age=" + age +
                '}';
    }
}
