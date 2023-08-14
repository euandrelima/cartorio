package br.com.escriba.andrelima.cartorio.resources;

import br.com.escriba.andrelima.cartorio.domain.Cartorio;
import br.com.escriba.andrelima.cartorio.services.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cartorios")
public class CartorioResource {

    @Autowired
    private CartorioService service;

    @GetMapping
    public ResponseEntity<Page<Cartorio>> findAll() {
        Page<Cartorio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
