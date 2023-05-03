package com.project.fri.gameRoom.controller;

import com.project.fri.common.entity.Category;
import com.project.fri.gameRoom.dto.*;
import com.project.fri.gameRoom.service.GameRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * packageName    : com.project.fri.gameRoom.controller fileName       : GameRoomController author
 *       : hagnoykmik date           : 2023-04-25 description    : ===========================================================
 * DATE              AUTHOR             NOTE -----------------------------------------------------------
 * 2023-04-25        hagnoykmik       최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/game-room")
@Slf4j
public class GameRoomController {

    private final GameRoomService gameRoomService;

    /**
     * 게임 방 정보조회
     * @param gameRoomId
     * @return
     */
    @GetMapping("/{gameRoomId}")
    public ResponseEntity<FindGameRoomResponse> findGameRoom(@PathVariable("gameRoomId") Long gameRoomId) {

        // todo: header에 담긴 userId로 교체
        Long userId = 4l;

        FindGameRoomResponse gameRoom = gameRoomService.findGameRoom(gameRoomId, userId);
        return ResponseEntity.status(200).body(gameRoom);
    }

    /**
     * 게임 방 더보기
     * @param page
     * @return
     */
    @GetMapping("/category")
    public ResponseEntity<List<FindAllGameRoomResponse>> findAllGameRoom(
            @RequestParam("area") Category area,
            @RequestParam("page") int page) {
        List<FindAllGameRoomResponse> allGameRoom = gameRoomService.findAllGameRoom(area, page, 20);
        return ResponseEntity.status(200).body(allGameRoom);
    }

    /**
     * 게임 방 생성
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<CreateGameRoomResponse> createGameRoom(@RequestBody @Valid CreateGameRoomRequest request) {

        // todo: header에 담긴 userId로 교체
        Long userId = 2l;

        CreateGameRoomResponse createGameRoom = gameRoomService.createGameRoom(request, userId);
        return ResponseEntity.status(201).body(createGameRoom);
    }

    /**
     * 게임 방 참여하기, 나가기
     * @param gameRoomId
     * @param request
     * @return
     */
    @PatchMapping("/{gameRoomId}/participation")
    public ResponseEntity<UpdateGameRoomParticipationResponse> updateGameRoomParticipation(
            @PathVariable("gameRoomId") Long gameRoomId,
            @RequestBody UpdateGameRoomParticipationRequest request) {

        // todo: header에 담긴 userId로 교체
        Long userId = 2l;

        UpdateGameRoomParticipationResponse updateGameRoomParticipation = gameRoomService.updateGameRoomParticipation(gameRoomId, request, userId);
        if (updateGameRoomParticipation == null) {
            return ResponseEntity.unprocessableEntity().build(); // todo: 클라이언트 요청이 유효하지 않은 경우
        } else {
            return ResponseEntity.status(201).body(updateGameRoomParticipation);
        }

    }

    /**
     * 게임방 목록조회
     * @param areaCategory
     * @return
     */
    @GetMapping
    public ResponseEntity<FindGameRoomListResponse> findGameRoomList(@RequestParam("area") Category areaCategory) {
        List<FindGameRoomInstance> gameRoomList = gameRoomService.findGameRoomList(areaCategory);
        FindGameRoomListResponse result = new FindGameRoomListResponse(gameRoomList);

        return ResponseEntity.ok().body(result);
    }

}
