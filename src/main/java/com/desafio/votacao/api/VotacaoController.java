package com.desafio.votacao.api;


import com.desafio.votacao.entidade.Pauta;
import com.desafio.votacao.service.PautaService;
import com.desafio.votacao.service.VotacaoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "v1/votacao")
public class VotacaoController {

    @Autowired
    private PautaService pautaService;

    @Autowired
    private VotacaoService votacaoService;


    @ApiResponse(responseCode = "302", description = "Consultar uma pauta via ID")
    @GetMapping(value = "/consultar/pauta/{pautaId}")
    @ResponseStatus(code = FOUND)
    public ResponseEntity<?> consultarPauta(@PathVariable @NotEmpty Long pautaId) {
        return pautaService.consultar(pautaId);
    }

    @ApiResponse(responseCode = "201", description = "Cadastrar uma nova pauta")
    @PostMapping(value = "/criar/pauta")
    @ResponseStatus(code = CREATED)
    public ResponseEntity<Pauta> criarPauta(@RequestBody @NotEmpty Pauta pauta) {
        return pautaService.criarPauta(pauta);
    }

    @ApiResponse(responseCode = "202", description = "Abrir uma pauta via e ID e data limite")
    @PostMapping(value = "/abrir/pauta/{pautaId}")
    @ResponseStatus(code = ACCEPTED)
    public ResponseEntity<Pauta> abrirPauta(@PathVariable @NotEmpty Long pautaId, @RequestBody @NotEmpty LocalDate dataFim) {
        return pautaService.abrirPauta(pautaId, dataFim);
    }

    @ApiResponse(responseCode = "202", description = "Realizar um voto via pautaID e CPF")
    @PostMapping(value = "/votar/{pautaId}")
    @ResponseStatus(code = ACCEPTED)
    public ResponseEntity<String> votar(@PathVariable @NotEmpty Long pautaId, @RequestBody @NotEmpty String cpf, @RequestBody @NotEmpty String voto) {
        return votacaoService.votar(pautaId, cpf, voto);
    }
}
