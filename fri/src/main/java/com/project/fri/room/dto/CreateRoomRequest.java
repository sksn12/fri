package com.project.fri.room.dto;

import com.project.fri.common.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * packageName    : com.project.fri.room.dto
 * fileName       : CreateRoomRequest
 * author         : hagnoykmik
 * date           : 2023-04-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-19        hagnoykmik       최초 생성
 */

@Data
public class CreateRoomRequest {

  @NotNull
  private String title;
  private int headCount;
  @NotNull
  private com.project.fri.room.entity.Category roomCategory;
  @NotNull
  private Category area;
  @NotNull
  private String location;

}
