package br.com.escriba.andrelima.cartorio.services;

import br.com.escriba.andrelima.cartorio.domain.Cartorio;
import br.com.escriba.andrelima.cartorio.repositories.CartorioRepository;
import br.com.escriba.andrelima.cartorio.services.execeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private CartorioRepository repository;

    public Cartorio findById(Integer id) {
        Optional<Cartorio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cartório não encontrado! Código: " + id));
    }

    public Page<Cartorio> findAll() {
        Pageable pageable = PageRequest.ofSize(10);
        return repository.findAll(pageable);
    }


}
