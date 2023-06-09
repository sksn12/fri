package com.project.fri.likes.repository;

import com.project.fri.board.entity.Board;
import com.project.fri.likes.entity.Likes;
import com.project.fri.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findByUserAndBoardAndIsDeleteFalse(User user, Board board);
    long countByBoardAndIsDeleteFalse(Board board);
}
