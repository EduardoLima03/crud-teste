package br.dev.carloslima.backend.model.dto;

public record UpdateUserDto(
        String name,
        String surname,
        String email,
        String password,
        Short active
) {}
