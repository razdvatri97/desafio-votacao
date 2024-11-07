package com.desafio.votacao.repositorio;

import com.desafio.votacao.entidade.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PautaRepositorio extends JpaRepository<Pauta, Long> {

    Optional<Pauta> findPautaById( long id );
}
