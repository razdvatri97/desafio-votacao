package com.desafio.votacao.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VotoDTO {

    @Valid
    @NotNull
    Long pautaId;

    @Valid
    @NotEmpty
    String cpf;

    @Valid
    @NotEmpty
    String voto;
}
