package br.com.escriba.andrelima.cartorio.services;

import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import br.com.escriba.andrelima.cartorio.repositories.SituacaoCartorioRepository;
import br.com.escriba.andrelima.cartorio.services.execeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SituacaoCartorioService {

    @Autowired
    private SituacaoCartorioRepository repository;

    public SituacaoCartorio findById(String id) {
        Optional<SituacaoCartorio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Situação não encontrada! Código: " + id));
    }
}
