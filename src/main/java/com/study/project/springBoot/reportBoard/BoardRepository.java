package com.study.project.springBoot.reportBoard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String searchKeyword);
    Page<Board> findBoardById(Long id, Pageable pageable);
    Page<Board> findBoardByTitle(String title, Pageable pageable);
}
