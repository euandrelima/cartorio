package br.com.escriba.andrelima.cartorio.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FieldMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
