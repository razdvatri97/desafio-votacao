package com.desafio.votacao.service;

import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotacaoService {
    public ResponseEntity<String> votar(@NotEmpty Long pautaId, @NotEmpty String cpf, @NotEmpty String voto) {
        return null;
    }
}
