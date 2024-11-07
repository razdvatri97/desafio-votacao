package com.desafio.votacao.service;

import com.desafio.votacao.entidade.Pauta;
import com.desafio.votacao.repositorio.PautaRepositorio;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class PautaService {

    PautaRepositorio repositorio;

    public ResponseEntity<?> consultar(@NotEmpty Long pautaId) {
        Optional<Pauta> pauta = repositorio.findPautaById(pautaId);

        if (pauta.isEmpty()) {
            String mensagemErro = "Esta pauta: " + pautaId + " não existe";
            return ResponseEntity.status(NOT_FOUND).body(mensagemErro);
        } else {
            return ResponseEntity.status(OK).body(pauta);
        }
    }

    public ResponseEntity<Pauta> criarPauta(@NotEmpty Pauta pauta) {
        return null;
    }

    public ResponseEntity<Pauta> abrirPauta(@NotEmpty Long pautaId, @NotEmpty LocalDate dataFim) {
        return null;
    }
}
