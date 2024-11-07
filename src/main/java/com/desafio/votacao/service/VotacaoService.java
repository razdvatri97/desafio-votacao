package com.desafio.votacao.service;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;

public class VotacaoService {
    public ResponseEntity<String> votar(@NotEmpty Long pautaId, @NotEmpty String cpf, @NotEmpty String voto) {
        return null;
    }
}
