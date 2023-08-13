package br.com.escriba.andrelima.cartorio.domain;

import br.com.escriba.andrelima.cartorio.domain.dtos.AtribuicaoCartorioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AtribuicaoCartorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(columnDefinition = "boolean default true")
    private boolean situacao;

    public AtribuicaoCartorio(AtribuicaoCartorioDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.situacao = obj.isSituacao();
    }

}
