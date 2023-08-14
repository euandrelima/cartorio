package br.com.escriba.andrelima.cartorio.services;

import br.com.escriba.andrelima.cartorio.domain.Cartorio;
import br.com.escriba.andrelima.cartorio.repositories.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartorioService {

    @Autowired
    private CartorioRepository repository;

    public Page<Cartorio> findAll() {
        Pageable pageable = PageRequest.ofSize(10);
        return repository.findAll(pageable);
    }
}
