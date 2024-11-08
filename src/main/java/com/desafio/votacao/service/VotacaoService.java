package com.desafio.votacao.service;

import com.desafio.votacao.dto.VotoDTO;
import com.desafio.votacao.entidade.Pauta;
import com.desafio.votacao.repositorio.PautaRepositorio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    @Autowired
    PautaRepositorio repositorio;

    static final String MENSAGEM_PAUTA_INEXISTENTE = "Pauta inexistente.";
    static final String MENSAGEM_ERRO_CPF = "Este CPF já votou nesta pauta.";
    static final String VOTO_INVALIDO_USE_SIM_OU_NAO = "Voto inválido. Use 'SIM' ou 'NAO'.";
    static final String DATA_ENCERRADA = "Data Limite para votação já foi encerrada.";

    public ResponseEntity<?> votar(@Valid VotoDTO voto) {


        Optional<Pauta> pautaDestinoVotoOptional = repositorio.findPautaById(voto.getPautaId());

        if (pautaDestinoVotoOptional.isEmpty()) {
            return ResponseEntity.status(BAD_REQUEST).body(MENSAGEM_PAUTA_INEXISTENTE);
        }

        if (LocalDateTime.now().isAfter(pautaDestinoVotoOptional.get().getDataFim())) {
            return ResponseEntity.status(BAD_REQUEST).body(DATA_ENCERRADA);
        }

        Pauta pautaDestinoVoto = pautaDestinoVotoOptional.get();

        if (pautaDestinoVoto.getEleitores().contains(voto.getCpf())) {
            return ResponseEntity.status(BAD_REQUEST).body(MENSAGEM_ERRO_CPF);
        }

        pautaDestinoVoto.getEleitores().add(voto.getCpf());

        if (voto.getVoto().equalsIgnoreCase("SIM")) {
            pautaDestinoVoto.setSim(pautaDestinoVoto.getSim() + 1);
        } else if (voto.getVoto().equalsIgnoreCase("NAO")) {
            pautaDestinoVoto.setNao(pautaDestinoVoto.getNao() + 1);
        } else {
            return ResponseEntity.status(BAD_REQUEST).body(VOTO_INVALIDO_USE_SIM_OU_NAO);
        }

        Pauta pautaAtualizada = repositorio.save(pautaDestinoVoto);
        return ResponseEntity.status(ACCEPTED).body(pautaAtualizada);
    }

}
