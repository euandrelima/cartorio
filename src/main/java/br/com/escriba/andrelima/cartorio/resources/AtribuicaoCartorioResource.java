package br.com.escriba.andrelima.cartorio.resources;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.AtribuicaoCartorioDTO;
import br.com.escriba.andrelima.cartorio.services.AtribuicaoCartorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/atribuicoes")
public class AtribuicaoCartorioResource {

    @Autowired
    private AtribuicaoCartorioService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AtribuicaoCartorioDTO> findById(@PathVariable String id) {
        AtribuicaoCartorio obj = service.findById(id);
        return ResponseEntity.ok().body(toAtribuicaoCartorioDTO(obj));
    }

    @GetMapping
    public ResponseEntity<Page<AtribuicaoCartorio>> findAll(Pageable pageable) {
        Page<AtribuicaoCartorio> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<AtribuicaoCartorioDTO> create(@RequestBody AtribuicaoCartorioDTO objDTO){
        AtribuicaoCartorio newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private AtribuicaoCartorioDTO toAtribuicaoCartorioDTO(AtribuicaoCartorio atribuicaoCartorio){
        return modelMapper.map(atribuicaoCartorio, AtribuicaoCartorioDTO.class);
    }


}
