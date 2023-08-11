package br.com.escriba.andrelima.cartorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoCartorioRepository extends JpaRepository<SituacaoCartorioRepository, String> {
}
