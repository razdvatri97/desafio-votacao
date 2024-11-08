package com.desafio.votacao.entidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pauta {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq")
    long id;

    @Column(nullable = false)
    @NotBlank
    String descricao;

    @Column
    int sim;

    @Column
    int nao;

    @Column(nullable = false)
    LocalDateTime dataInicio;

    @Column
    LocalDateTime dataFim;

    @Column
    List<String> eleitores;


}
