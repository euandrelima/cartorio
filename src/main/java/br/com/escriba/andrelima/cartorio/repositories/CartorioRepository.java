package br.com.escriba.andrelima.cartorio.repositories;

import br.com.escriba.andrelima.cartorio.domain.Cartorio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartorioRepository extends PagingAndSortingRepository<Cartorio, Integer> {
}
