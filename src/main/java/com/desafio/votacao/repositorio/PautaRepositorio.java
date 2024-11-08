package com.desafio.votacao.repositorio;

import com.desafio.votacao.entidade.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaRepositorio extends JpaRepository<Pauta, Long> {

    Optional<Pauta> findPautaById( long id );
}
