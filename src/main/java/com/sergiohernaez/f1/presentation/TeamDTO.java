package com.sergiohernaez.f1.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TeamDTO {

    private Long id;
    private String name;
    private String yearOfCreation;
    private Long championshipsWon;
    private Boolean entryFeePaid;

}
