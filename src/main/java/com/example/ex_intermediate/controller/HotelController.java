package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル関連情報の処理の制御を行うコントローラです.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * ホテル検索画面へ遷移する.
     *
     * @param model モデル
     * @return ホテル検索画面
     */
    @GetMapping("")
    public String index(Model model){
        return "main";
    }

    /**
     *価格からホテルを検索する.
     *
     * @param price 価格
     * @param model モデル
     * @return 検索結果画面
     */
    @PostMapping("/search")
    public String search(Integer price,Model model){
        List<Hotel> hotelList = hotelService.findByPrice(price);
        model.addAttribute("hotelList",hotelList);
        model.addAttribute("price",price);
        return "search-hotel";
    }

}
