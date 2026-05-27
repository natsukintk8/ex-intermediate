package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.BaseballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * teamsテーブルを操作するリポジトリです.
 */
@Repository
public class BaseballTeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<BaseballTeam> BASEBALL_TEAM_ROW_MAPPER
            = (rs,i) -> {
        BaseballTeam baseballTeam = new BaseballTeam();
        baseballTeam.setId(rs.getInt("id"));
        baseballTeam.setLeagueName(rs.getString("league_name"));
        baseballTeam.setTeamName(rs.getString("team_name"));
        baseballTeam.setHeadquarters(rs.getString("headquarters"));
        baseballTeam.setInauguration(rs.getString("inauguration"));
        baseballTeam.setHistory(rs.getString("history"));
        return baseballTeam;
    };

    /**
     * 指定された野球チームの情報を検索する.
     *
     * @param id ID
     * @return 野球チーム情報
     */
    public BaseballTeam findById(Integer id){
        String sql = """
                SELECT
                  id,league_name,team_name,headquarters,inauguration,history
                 FROM
                  teams
                 WHERE
                  id = :id
                """;

        SqlParameterSource param =new MapSqlParameterSource()
                .addValue("id",id);

        return template.queryForObject(sql,param,BASEBALL_TEAM_ROW_MAPPER);
        }

    /**
     *野球チームの情報を全件検索する.
     *
     * @return 全野球チーム情報
     */
    public List<BaseballTeam> findAll(){
        String sql = """
                 SELECT
                  id,league_name,team_name,headquarters,inauguration,history
                 FROM
                  teams
                 ORDER BY
                  inauguration ASC
                """;

        return template.query(sql,BASEBALL_TEAM_ROW_MAPPER);
        }
    }

