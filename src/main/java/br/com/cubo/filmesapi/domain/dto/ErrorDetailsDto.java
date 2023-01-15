package br.com.cubo.filmesapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetailsDto {
    private LocalDateTime timestamp;

    private String message;

    private String details;
}
