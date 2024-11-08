package com.desafio.votacao.service;

import com.desafio.votacao.dto.PautaDataFimDTO;
import com.desafio.votacao.entidade.Pauta;
import com.desafio.votacao.repositorio.PautaRepositorio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Collections.emptyList;
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
                .dataFim(LocalDateTime.MIN)
                .eleitores(emptyList())
                .build();

        Pauta pautaSalva = repositorio.save(novaPauta);
        return ResponseEntity.status(CREATED).body(pautaSalva);
    }

    public ResponseEntity<?> abrirPauta(@NotEmpty Long pautaId, @NotEmpty PautaDataFimDTO dataFim) {
        Optional<Pauta> pauta = repositorio.findPautaById(pautaId);

        if (pauta.isPresent()) {
            pauta.get().setDataFim(dataFim.getDataFim());

            Pauta pautaAtualizada = repositorio.save(pauta.get());
            return ResponseEntity.status(ACCEPTED).body(pautaAtualizada);
        } else {
            String mensagemErro = "Esta pauta: " + pautaId + " não existe";
            return ResponseEntity.status(NOT_FOUND).body(mensagemErro);
        }
    }
}
