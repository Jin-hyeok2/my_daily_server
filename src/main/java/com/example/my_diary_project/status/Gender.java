package com.example.my_diary_project.status;

import lombok.Getter;

@Getter
public enum Gender {
  MALE("M", "Male"),
  FEMALE("F", "Female"),
  UNKNOWN("?", "Unknown");

  private final String shortCut;
  private final String mean;
  Gender(String shortCut, String mean) {
    this.shortCut = shortCut;
    this.mean = mean;
  }

  public static Gender getGender(String shortCut) {
    for (Gender gender : Gender.values()) {
        if (gender.shortCut.equals(shortCut)) {
            return gender;
        }
    }
    return UNKNOWN;
  }
}


