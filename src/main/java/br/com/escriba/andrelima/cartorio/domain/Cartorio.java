package br.com.escriba.andrelima.cartorio.domain;

import br.com.escriba.andrelima.cartorio.domain.dtos.CartorioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cartorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    @Column(length = 150, nullable = false)
    private String nome;
    @Column(length = 250)
    private String observacao;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situacao_cartorio_id", unique = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SituacaoCartorio situacaoCartorio;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @Column(nullable = false)
    private List<AtribuicaoCartorio> atribuicoes;

    public Cartorio(CartorioDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.observacao = obj.getObservacao();
        this.situacaoCartorio = obj.getSituacaoCartorio();
        this.atribuicoes = obj.getAtribuicoes();
    }

}
