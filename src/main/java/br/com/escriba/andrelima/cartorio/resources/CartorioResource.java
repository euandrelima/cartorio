package br.com.escriba.andrelima.cartorio.resources;

import br.com.escriba.andrelima.cartorio.domain.Cartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.CartorioDTO;
import br.com.escriba.andrelima.cartorio.services.CartorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cartorios")
public class CartorioResource {

    @Autowired
    private CartorioService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CartorioDTO> findById(@PathVariable Integer id) {
        Cartorio obj = service.findById(id);
        return ResponseEntity.ok().body(toCartorioDTO(obj));
    }

    @GetMapping
    public ResponseEntity<Page<Cartorio>> findAll() {
        Page<Cartorio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CartorioDTO> create(@RequestBody CartorioDTO objDTO){
        Cartorio newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private CartorioDTO toCartorioDTO(Cartorio cartorio){
        return modelMapper.map(cartorio, CartorioDTO.class);
    }
}
