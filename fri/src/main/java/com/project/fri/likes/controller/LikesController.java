package com.project.fri.likes.controller;

import com.project.fri.likes.dto.CreateLikesRequest;
import com.project.fri.likes.dto.CreateLikesResponse;
import com.project.fri.likes.dto.DeleteLikesRequest;
import com.project.fri.likes.dto.DeleteLikesResponse;
import com.project.fri.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
@Slf4j
public class LikesController {
    private final LikesService likesService;

    /**
     * 좋아요 생성
     * @param createLikesRequest 요청
     * @param userId Authorization
     * @return 응답
     */
    @PostMapping
    public ResponseEntity<CreateLikesResponse> createLikes(
            @RequestBody CreateLikesRequest createLikesRequest, @RequestHeader("Authorization") Long userId) {
        CreateLikesResponse result = likesService.createLikes(createLikesRequest, userId);

        if (result == null) {
            return ResponseEntity.badRequest().body(new CreateLikesResponse(true));
        }
        return ResponseEntity.status(201).body(result);
    }

    /**
     * 좋아요 취소
     * @param deleteLikesRequest 요청
     * @param userId Authorization
     * @return 응답
     */
    @PatchMapping
    public ResponseEntity<DeleteLikesResponse> deleteLikes(
            @Valid @RequestBody DeleteLikesRequest deleteLikesRequest, @RequestHeader("Authorization") Long userId) {
        DeleteLikesResponse result = likesService.deleteLikes(deleteLikesRequest, userId);

        if (result == null) {
            return ResponseEntity.badRequest().body(new DeleteLikesResponse(false));
        }

        return ResponseEntity.ok().body(result);
    }
}
