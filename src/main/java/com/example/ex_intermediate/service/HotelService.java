package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル情報関連の業務処理を行うサービスです.
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * 価格からホテルを検索する.
     *
     * @param price 価格
     * @return 検索結果
     */
    public List<Hotel> findByPrice(Integer price){
        return hotelRepository.findByPrice(price);
    }
}
