package com.cem.monolithichomework.dto.response;

import com.cem.monolithichomework.repository.entity.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFindAllResponseDto {

    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private EGender gender;
}
