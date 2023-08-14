package br.com.escriba.andrelima.cartorio.domain.dtos;

import br.com.escriba.andrelima.cartorio.domain.AtribuicaoCartorio;
import br.com.escriba.andrelima.cartorio.domain.SituacaoCartorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartorioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String observacao;
    private SituacaoCartorio situacaoCartorio;
    private List<AtribuicaoCartorio> atribuicoes;

    public CartorioDTO(CartorioDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.observacao = obj.getObservacao();
        this.situacaoCartorio = obj.getSituacaoCartorio();
        this.atribuicoes = obj.getAtribuicoes();
    }

}
