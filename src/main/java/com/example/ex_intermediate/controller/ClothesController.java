package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Clothes;
import com.example.ex_intermediate.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 衣類関連情報の処理の制御を行うコントローラです.
 */
@Controller
@RequestMapping("/clothes")
public class ClothesController {
    @Autowired
    private ClothesService clothesService;

    /**
     * 衣類検索画面に遷移する.
     *
     * @param model モデル
     * @return 衣類検索画面
     */
    @GetMapping("")
    public String index(Model model){
        return "clothes-search";
    }

    /**
     * 色と性別から衣類を探す.
     *
     * @param color 色
     * @param gender 性別
     * @param model モデル
     * @return 衣類検索結果画面
     */
    @PostMapping("/search")
    public String searchByColorAndGender(String color,Integer gender,Model model){
        List<Clothes> clothesList = clothesService.searchByColorAndGender(color,gender);
        model.addAttribute("clothesList",clothesList);
        String error = "検索結果に合うものはありません";
        model.addAttribute("error",error);
        return "clothes-search";
    }
}
