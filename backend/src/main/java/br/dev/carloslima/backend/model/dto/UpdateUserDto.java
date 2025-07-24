package br.dev.carloslima.backend.model.dto;

import java.util.Set;

public record UpdateUserDto(
        String name,
        String surname,
        String email,
        String password,
        Short active,
        Set<Integer> permissionIds
) {}
