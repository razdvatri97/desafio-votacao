package com.desafio.votacao.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

public record Pauta(@Id @GeneratedValue(strategy = SEQUENCE) long id,
                    @Column(nullable = false) @NotBlank String descricao,
                    @Column(nullable = false) @NotEmpty int sim,
                    @Column(nullable = false) @NotEmpty int nao,
                    @Column(nullable = false) LocalDateTime dataInicio,
                    @Column(nullable = false) LocalDateTime dataFim) {
}
