package com.desafio.votacao.service;

import com.desafio.votacao.entidade.Pauta;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

public class PautaService {
    public Optional<Pauta> consultar(@NotEmpty Long pautaId) {
        return null;
    }

    public ResponseEntity<Pauta> criarPauta(@NotEmpty Pauta pauta) {
        return null;
    }

    public ResponseEntity<Pauta> abrirPauta(@NotEmpty Long pautaId, @NotEmpty LocalDate dataFim) {
        return null;
    }
}
