package br.com.escriba.andrelima.cartorio.repositories;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtribuicaoCartorioResository extends PagingAndSortingRepository<AtribuicaoCartorio, String> {
    Optional<AtribuicaoCartorio> findByNome(String nome);
}
