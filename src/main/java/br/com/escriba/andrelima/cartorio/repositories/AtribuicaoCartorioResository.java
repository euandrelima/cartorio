package br.com.escriba.andrelima.cartorio.repositories;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtribuicaoCartorioResository extends PagingAndSortingRepository<AtribuicaoCartorio, String> {
}
