package com.desafio.votacao.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public record Pauta(@Id @GeneratedValue(strategy = SEQUENCE) long id,
                    @Column(nullable = false) @NotBlank String descricao,
                    @Column(nullable = false) @NotEmpty int sim,
                    @Column(nullable = false) @NotEmpty int nao,
                    @Column(nullable = false) LocalDateTime dataInicio,
                    @Column(nullable = false) LocalDateTime dataFim) {
}
