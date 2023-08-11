package br.com.escriba.andrelima.cartorio.domain;

import br.com.escriba.andrelima.cartorio.domain.dtos.SituacaoCartorioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SituacaoCartorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 50, nullable = false)
    private String nome;

    public SituacaoCartorio(SituacaoCartorioDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

}
