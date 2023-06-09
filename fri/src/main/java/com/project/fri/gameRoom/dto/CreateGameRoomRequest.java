package com.project.fri.gameRoom.dto;

import com.project.fri.common.entity.Category;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * packageName    : com.project.fri.gameRoom.dto fileName       : CreateGameRoomRequest author :
 * hagnoykmik date           : 2023-04-25 description    :
 * =========================================================== DATE              AUTHOR
 * NOTE ----------------------------------------------------------- 2023-04-25        hagnoykmik
 * 최초 생성
 */

@Data
public class CreateGameRoomRequest {

  @NotNull
  private String title;
  private int headCount;
  @NotNull
  private Category area;
  @NotNull
  private String location;
}
