package br.com.escriba.andrelima.cartorio.repositories;

import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SituacaoCartorioRepository extends PagingAndSortingRepository<SituacaoCartorio, String> {
    Optional<SituacaoCartorio> findByNome(String nome);
}