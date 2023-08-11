package br.com.escriba.andrelima.cartorio.services;

import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.SituacaoCartorioDTO;
import br.com.escriba.andrelima.cartorio.repositories.SituacaoCartorioRepository;
import br.com.escriba.andrelima.cartorio.services.execeptions.DuplicateObjectException;
import br.com.escriba.andrelima.cartorio.services.execeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public SituacaoCartorio create(SituacaoCartorioDTO objDTO) {
        verificaIdExistente(objDTO);
        verificaNomeExistente(objDTO);
        SituacaoCartorio newObj = new SituacaoCartorio(objDTO);
        return repository.save(newObj);
    }

    public Page<SituacaoCartorio> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public SituacaoCartorio update(String id, SituacaoCartorioDTO objDTO) {
        objDTO.setId(id);
        SituacaoCartorio oldObj = findById(id);
        verificaNomeExistente(objDTO);
        oldObj = new SituacaoCartorio(objDTO);
        return repository.save(oldObj);
    }

    public void delete(String id) {
        SituacaoCartorio obj = findById(id);
        // TODO: Realizar implementação futura das validações para exclusão
        repository.deleteById(id);
    }

    private void verificaIdExistente(SituacaoCartorioDTO objDTO) {
        Optional<SituacaoCartorio> obj = repository.findById(objDTO.getId());
        if(obj.isPresent() && obj.get().getId() == objDTO.getId()) {
            throw new DuplicateObjectException("Registro já cadastrado");
        }
    }
    private void verificaNomeExistente(SituacaoCartorioDTO objDTO) {
        Optional<SituacaoCartorio> obj = repository.findByNome(objDTO.getNome());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw  new DuplicateObjectException("Nome já informado no registro com código " + obj.get().getId());
        }
    }

}
