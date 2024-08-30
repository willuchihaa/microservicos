package br.will.msUsuario.infrastructure.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    
    private Boolean success;
    private String message;

    //parametro do lado da classe
    private T result;
    private ErrorResponse error;
}
