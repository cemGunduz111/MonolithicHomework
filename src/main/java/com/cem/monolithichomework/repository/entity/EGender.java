package com.cem.monolithichomework.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum EGender {
    MALE("Erkek"), FEMALE("Kadın");

    String gender;
    EGender(String gender) {
        this.gender = gender;
    }
}
