package com.fundamentos.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;

    private String name;

    private LocalDate birtDate;
}
