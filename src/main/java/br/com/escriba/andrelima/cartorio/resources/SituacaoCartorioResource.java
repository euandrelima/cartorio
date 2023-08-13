package br.com.escriba.andrelima.cartorio.resources;

import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.SituacaoCartorioDTO;
import br.com.escriba.andrelima.cartorio.services.SituacaoCartorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/situacoes")
public class SituacaoCartorioResource {

    @Autowired
    private SituacaoCartorioService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SituacaoCartorioDTO> findById(@PathVariable String id) {
        SituacaoCartorio obj = service.findById(id);
        return ResponseEntity.ok().body(toSituacaoCartorioDTO(obj));
    }

    @GetMapping
    public ResponseEntity<Page<SituacaoCartorio>> findAll(Pageable pageable) {
        Page<SituacaoCartorio> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<SituacaoCartorioDTO> create(@RequestBody SituacaoCartorioDTO objDTO){
        SituacaoCartorio newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SituacaoCartorioDTO> update(@PathVariable String id, @RequestBody SituacaoCartorioDTO objDTO){
        SituacaoCartorio obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new SituacaoCartorioDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SituacaoCartorioDTO> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private SituacaoCartorioDTO toSituacaoCartorioDTO(SituacaoCartorio situacaoCartorio){
        return modelMapper.map(situacaoCartorio, SituacaoCartorioDTO.class);
    }
}
