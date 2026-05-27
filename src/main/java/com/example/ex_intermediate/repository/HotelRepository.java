package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリです.
 */
@Repository
public class HotelRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Hotel.class);

    /**
     * 価格からホテルを検索する.
     *
     * @param price 価格
     * @return 検索結果
     */
    public List<Hotel> findByPrice(Integer price){
        String sql = """
                 SELECT
                  id,area_name,hotel_name,address,nearest_station,price,parking
                 FROM
                  hotels
                 WHERE
                  price <= :price
                 ORDER BY
                  price DESC
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("price",price);

        return template.query(sql,param,HOTEL_ROW_MAPPER);
    }
}
