package com.example.prj1.controller;

import com.example.prj1.dto.BoardForm;
import com.example.prj1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class board {


    private final BoardService boardService;

    @GetMapping("write")
    public String writeForm() {

        return "board/write";
    }

    @PostMapping("write")
    public String writePost(BoardForm data) {

        boardService.add(data);

        return "redirect:/board/list";
    }

    @GetMapping("list")
    public String list(
            @RequestParam(defaultValue = "1")
            Integer page,
            Model model) {

        var result = boardService.list(page);

        model.addAttribute("boardList", result);

        return "board/list";
    }
}