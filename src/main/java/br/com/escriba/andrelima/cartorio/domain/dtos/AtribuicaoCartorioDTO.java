package br.com.escriba.andrelima.cartorio.domain.dtos;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AtribuicaoCartorioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private boolean situacao;

    public AtribuicaoCartorioDTO(AtribuicaoCartorio obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.situacao = obj.isSituacao();
    }


}
