package com.project.fri.user.dto;

import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.project.fri.user.dto fileName       : CertifiedUserRequest date           :
 * 2023-04-30 description    :
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@AllArgsConstructor
@Builder
public class CertifiedEduRequest {
  @NotNull
  private String email;

  private boolean emailAgreement;
}
