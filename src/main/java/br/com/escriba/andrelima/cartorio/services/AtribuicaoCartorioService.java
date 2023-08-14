package br.com.escriba.andrelima.cartorio.services;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.AtribuicaoCartorioDTO;
import br.com.escriba.andrelima.cartorio.repositories.AtribuicaoCartorioResository;
import br.com.escriba.andrelima.cartorio.services.execeptions.DuplicateObjectException;
import br.com.escriba.andrelima.cartorio.services.execeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public AtribuicaoCartorio create(AtribuicaoCartorioDTO objDTO) {
        verificaIdExistente(objDTO);
        verificaNomeExistente(objDTO);
        AtribuicaoCartorio newObj = new AtribuicaoCartorio(objDTO);
        return repository.save(newObj);
    }

    public Page<AtribuicaoCartorio> findAll() {
        Pageable pageable = PageRequest.ofSize(10);
        return repository.findAll(pageable);
    }

    public AtribuicaoCartorio update(String id, AtribuicaoCartorioDTO objDTO) {
        objDTO.setId(id);
        AtribuicaoCartorio oldObj = findById(id);
        verificaNomeExistente(objDTO);
        oldObj = new AtribuicaoCartorio(objDTO);
        return repository.save(oldObj);
    }

    private void verificaIdExistente(AtribuicaoCartorioDTO objDTO) {
        Optional<AtribuicaoCartorio> obj = repository.findById(objDTO.getId());
        if(obj.isPresent() && obj.get().getId() == objDTO.getId()) {
            throw new DuplicateObjectException("Registro já cadastrado");
        }
    }

    private void verificaNomeExistente(AtribuicaoCartorioDTO objDTO) {
        Optional<AtribuicaoCartorio> obj = repository.findByNome(objDTO.getNome());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw  new DuplicateObjectException("Nome já informado no registro com código " + obj.get().getId());
        }
    }

}
