package com.restapi.restapi.controller;

import com.restapi.restapi.entity.Board;
import com.restapi.restapi.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final BoardRepository boardRepository;

    @Cacheable(key = "#id" ,value = "boardSelect")
    @GetMapping("/{id}")
    public String main(@PathVariable Long id, Model model){
        model.addAttribute("board",boardRepository.findById(id).get());
        return "main";
    }
    @PostMapping("/add")
    public String add(){
        Board board = new Board();
        List<Board> board1 = boardRepository.findAll();
        for (int i = 0; i < 100; i++) {
            board.setTitle("제목"+i);
            board.setContent("내용"+i);
        }
        boardRepository.save(board);
        return "redirect:/1";
    }
}
