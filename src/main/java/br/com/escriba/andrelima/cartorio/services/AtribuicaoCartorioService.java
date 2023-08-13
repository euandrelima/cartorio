package br.com.escriba.andrelima.cartorio.services;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import br.com.escriba.andrelima.cartorio.repositories.AtribuicaoCartorioResository;
import br.com.escriba.andrelima.cartorio.services.execeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AtribuicaoCartorioService {

    @Autowired
    private AtribuicaoCartorioResository repository;

    public AtribuicaoCartorio findById(String id) {
        Optional<AtribuicaoCartorio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Atribuição não encontrada! Código: " + id));
    }

    public Page<AtribuicaoCartorio> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
