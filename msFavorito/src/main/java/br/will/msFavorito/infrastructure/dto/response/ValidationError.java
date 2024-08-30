package br.will.msFavorito.infrastructure.dto.response;

import java.util.List;

public record ValidationError(String code, String message, List<ValidationError> validations) {
    
}
