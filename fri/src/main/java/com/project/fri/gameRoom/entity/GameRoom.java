package com.project.fri.gameRoom.entity;

import com.project.fri.common.entity.Area;
import com.project.fri.gameRoom.dto.CreateGameRoomRequest;
import com.project.fri.user.entity.User;
import com.project.fri.util.BaseEntity;
import com.project.fri.util.BaseTimeEntity;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.project.fri.gameRoom.entity fileName       : GameRoom author         : hagnoykmik
 * date           : 2023-04-25 description    : ===========================================================
 * DATE              AUTHOR             NOTE -----------------------------------------------------------
 * 2023-04-25        hagnoykmik       최초 생성
 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="game_room")
public class GameRoom extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="game_room_id")
  private Long id;
  @NotNull
  private String title;

  private int headCount;
  @NotNull
  private String location;

  private double randomTime;

  private boolean isDelete;
  private int readyCount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "area_id")
  @NotNull
  private Area area;

  @Embedded
  @NotNull
  private BaseEntity baseEntity;

  //==생성메서드==//
  public static GameRoom create(CreateGameRoomRequest request, Area area, User user, double time) {
    GameRoom gameRoom = GameRoom.builder()
        .title(request.getTitle())
        .headCount(request.getHeadCount())
        .randomTime(time)
        .readyCount(0) //처음 생성할 때는 0으로 생성
        .area(area)
        .location(request.getLocation())
        .baseEntity(BaseEntity.builder()
            .constructor(user.getName())
            .updater(user.getName())
            .build())
        .build();
    return gameRoom;
  }

  //==비즈니스로직==//
  /**
   * 삭제 여부 변경
   */
  public GameRoom updateIsDelete(boolean isDelete) {
    this.isDelete = isDelete;
    return this;
  }

  public int updateReadyCount(int value){ //+-로 값을 받는다.
    this.readyCount += value;
    return this.readyCount;
  }
}
