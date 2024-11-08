package com.desafio.votacao.api;


import com.desafio.votacao.dto.PautaDataFimDTO;
import com.desafio.votacao.dto.VotoDTO;
import com.desafio.votacao.entidade.Pauta;
import com.desafio.votacao.service.PautaService;
import com.desafio.votacao.service.VotacaoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "v1/votacao")
public class VotacaoController {

    @Autowired
    private PautaService pautaService;

    @Autowired
    private VotacaoService votacaoService;


    @ApiResponse(responseCode = "302", description = "Consultar uma pauta via ID ")
    @GetMapping(value = "/consultar/pauta/{pautaId}")
    @ResponseStatus(code = FOUND)
    public ResponseEntity<?> consultarPauta(@PathVariable @Valid Long pautaId) {
        return pautaService.consultar(pautaId);
    }

    @ApiResponse(responseCode = "201", description = "Cadastrar uma nova pauta")
    @PostMapping(value = "/criar/pauta")
    @ResponseStatus(code = CREATED)
    public ResponseEntity<?> criarPauta(@RequestBody @Valid Pauta pauta) {
        return pautaService.criarPauta(pauta);
    }

    @ApiResponse(responseCode = "202", description = "Abrir uma pauta via e ID e data limite")
    @PatchMapping(value = "/abrir/pauta/{pautaId}")
    @ResponseStatus(code = ACCEPTED)
    public ResponseEntity<?> abrirPauta(@PathVariable @Valid Long pautaId, @RequestBody @Valid PautaDataFimDTO pautaDataFimDTO) {
        return pautaService.abrirPauta(pautaId, pautaDataFimDTO);
    }

    @ApiResponse(responseCode = "202", description = "Realizar um voto via pautaID e CPF")
    @PatchMapping(value = "/votar")
    @ResponseStatus(code = ACCEPTED)
    public ResponseEntity<?> votar(@RequestBody @Valid VotoDTO voto) {
        return votacaoService.votar(voto);
    }
}
