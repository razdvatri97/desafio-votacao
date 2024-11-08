package com.desafio.votacao.service;

import com.desafio.votacao.entidade.Pauta;
import com.desafio.votacao.repositorio.PautaRepositorio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static java.util.Collections.*;
import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class PautaService {

    @Autowired
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

    public ResponseEntity<?> criarPauta(@Valid Pauta pauta) {

        Pauta novaPauta = Pauta.builder()
                .descricao(pauta.getDescricao())
                .dataInicio(pauta.getDataInicio())
                .dataFim(pauta.getDataFim())
                .eleitores(emptyList())
                .build();

        Pauta pautaSalva = repositorio.save(novaPauta);
        return ResponseEntity.status(CREATED).body(pautaSalva);
    }

    public ResponseEntity<Pauta> abrirPauta(@NotEmpty Long pautaId, @NotEmpty LocalDate dataFim) {
        return null;
    }
}
