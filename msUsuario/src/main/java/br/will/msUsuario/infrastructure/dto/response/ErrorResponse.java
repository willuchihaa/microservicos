package br.will.msUsuario.infrastructure.dto.response;

import java.util.List;

public record ErrorResponse ( String code, String message, List<ValidationError> validations) {


}
