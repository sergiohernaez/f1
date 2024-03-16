package com.sergiohernaez.f1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="team")
public class Team {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="date-creation", nullable=false)
    private LocalDate dateOfCreation;

    @Column(name="championships-won", nullable=false)
    private Long championshipsWon;

    @Column(name="entry-fee-paid", nullable=false)
    private Boolean entryFeePaid;

    public String getYearOfCreation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return this.getDateOfCreation().format(formatter);
    }

}
