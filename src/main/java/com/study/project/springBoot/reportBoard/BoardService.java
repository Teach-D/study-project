package com.study.project.springBoot.reportBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글 작성
    public Board save(Board board) {
        boardRepository.save(board);
        return board;
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Page<Board> pageFindAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }


    public Board findById(Long id) {
        Board findBoard = boardRepository.findById(id).get();
        return findBoard;
    }

    public Page<Board> pageFindById(Long id, Pageable pageable) {
        Page<Board> boards = boardRepository.findBoardById(id, pageable);
        return boards;
    }

    public List<Board> findByTitle(String title) {
        List<Board> byTitleContaining = boardRepository.findByTitleContaining(title);
        return byTitleContaining;
    }

    public Page<Board> pagedFindByTitle(String title, Pageable pageable) {
        Page<Board> byTitleContaining = boardRepository.findBoardByTitle(title, pageable);
        return byTitleContaining;
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public void updateBoard(Long id, Board boardSearch) {
        Board board = boardRepository.findById(id).get();
        Board updatedBoard = new Board(board.getId(), boardSearch.getTitle(), boardSearch.getContent());
        boardRepository.save(updatedBoard);
    }


}