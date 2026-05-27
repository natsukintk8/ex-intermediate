package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリです.
 */
@Repository
public class ClothesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Clothes.class);

    /**
     * 色と性別から衣類を検索する.
     *
     * @return 検索結果
     */
    public List<Clothes> findByColorAndGender(String color, Integer gender) {
        String sql = """
                 SELECT
                  id,category,genre,gender,color,price,size
                 FROM
                  clothes
                 WHERE
                  color = :color
                  AND
                  gender = :gender
                 ORDER BY
                  price ASC
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("color", color)
                .addValue("gender", gender);
        return template.query(sql,param,CLOTHES_ROW_MAPPER);
    }

}
