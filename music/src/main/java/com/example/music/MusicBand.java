package com.example.music;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MusicBand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genere genere;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearOfFoundation;

    private String members;
    private String pastMembers;
    private String image;

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

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public LocalDate getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(LocalDate yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getPastMembers() {
        return pastMembers;
    }

    public void setPastMembers(String pastMembers) {
        if (!pastMembers.equals(""))
            this.pastMembers = pastMembers;
        else
            this.pastMembers = "-";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
