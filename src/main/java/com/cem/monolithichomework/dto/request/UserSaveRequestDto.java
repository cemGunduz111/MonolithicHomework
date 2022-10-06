package com.cem.monolithichomework.dto.request;

import com.cem.monolithichomework.repository.entity.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveRequestDto {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EGender gender;
}
