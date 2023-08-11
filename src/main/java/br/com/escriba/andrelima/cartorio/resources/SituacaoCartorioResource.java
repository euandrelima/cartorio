package br.com.escriba.andrelima.cartorio.resources;

import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.dtos.SituacaoCartorioDTO;
import br.com.escriba.andrelima.cartorio.services.SituacaoCartorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private SituacaoCartorioDTO toSituacaoCartorioDTO(SituacaoCartorio situacaoCartorio){
        return modelMapper.map(situacaoCartorio, SituacaoCartorioDTO.class);
    }
}
