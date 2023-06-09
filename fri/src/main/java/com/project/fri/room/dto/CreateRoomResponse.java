package com.project.fri.room.dto;

import com.project.fri.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * packageName    : com.project.fri.room.dto fileName       : CreateRoomResponse author         :
 * hagnoykmik date           : 2023-04-19 description    : ===========================================================
 * DATE              AUTHOR             NOTE -----------------------------------------------------------
 * 2023-04-19        hagnoykmik       최초 생성
 */
@Builder
@AllArgsConstructor
@Data
public class CreateRoomResponse {
  private Long roomId;
  private String title;

  public static CreateRoomResponse create(Room room) {
    CreateRoomResponse createRoomResponse = CreateRoomResponse.builder()
        .roomId(room.getId())
        .title(room.getTitle())
        .build();
    return createRoomResponse;
  }
}