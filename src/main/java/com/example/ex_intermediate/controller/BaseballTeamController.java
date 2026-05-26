package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.BaseballTeam;
import com.example.ex_intermediate.service.BaseballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *野球チーム関連情報の処理の制御を行うコントローラです.
 *
 */
@Controller
@RequestMapping("/baseball-team")
public class BaseballTeamController {
    @Autowired
    private BaseballTeamService baseballTeamService;

    /**
     *野球チーム一覧画面を表示する.
     *
     * @return 野球チーム一覧画面
     */
    @GetMapping("")
    public String showList(Model model){
        List<BaseballTeam> teamList =baseballTeamService.findAll();
        model.addAttribute("teamList",teamList);
        return "list";
    }

    /**
     *野球チームの詳細情報を表示する.
     *
     * @param id ID
     * @return 詳細情報画面
     */
    @GetMapping("/show-detail")
    public String showDetail(Integer id,Model model){
        BaseballTeam baseballTeam = baseballTeamService.findById(id);
        model.addAttribute("baseballTeam",baseballTeam);
        return "detail";
    }

    /**
     * 野球チーム一覧画面を再度表示する.
     *
     * @return 野球チーム一覧画面
     */
    @PostMapping("/back")
    public String back(){
        return "redirect:/baseball-team";
    }
}
