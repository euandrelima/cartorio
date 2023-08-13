package br.com.escriba.andrelima.cartorio.resources;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.AtribuicaoCartorioDTO;
import br.com.escriba.andrelima.cartorio.services.AtribuicaoCartorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private AtribuicaoCartorioDTO toAtribuicaoCartorioDTO(AtribuicaoCartorio atribuicaoCartorio){
        return modelMapper.map(atribuicaoCartorio, AtribuicaoCartorioDTO.class);
    }
}
