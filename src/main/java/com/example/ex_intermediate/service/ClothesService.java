package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Clothes;
import com.example.ex_intermediate.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類関連情報の業務処理を行うサービスです.
 */
@Service
@Transactional
public class ClothesService {
    @Autowired
    private ClothesRepository clothesRepository;

    /**
     * 色と性別から衣類を検索する.
     *
     * @param color 色
     * @param gender 性別
     * @return 検索結果
     */
    public List<Clothes> searchByColorAndGender(String color,Integer gender){
        return clothesRepository.findByColorAndGender(color,gender);
    }
}
