package br.com.escriba.andrelima.cartorio.repositories;

import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoCartorioRepository extends JpaRepository<SituacaoCartorio, String> {
}
