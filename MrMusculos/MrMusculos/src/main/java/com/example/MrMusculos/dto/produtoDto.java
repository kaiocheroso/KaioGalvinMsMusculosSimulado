package com.example.MrMusculos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.time.LocalTime;

public record produtoDto(

        @NotBlank(message = "preencha o campo")
        String Nome,

        @NotNull(message = "preencha o campo")
        @PositiveOrZero(message = "a quantidade nao pode ser negativa")
        Integer Quantidade,

        @NotNull(message = "preencha o campo")
        LocalDate DataSaida,

        @NotNull(message = "preencha o campo")
        LocalTime HoraSaida

){}
