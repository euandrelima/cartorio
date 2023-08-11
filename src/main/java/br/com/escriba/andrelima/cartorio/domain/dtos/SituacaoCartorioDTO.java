package br.com.escriba.andrelima.cartorio.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SituacaoCartorioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

}
