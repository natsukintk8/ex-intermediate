package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.BaseballTeam;
import com.example.ex_intermediate.repository.BaseballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 野球チーム情報関連の業務処理を行うサービスです.
 */
@Service
@Transactional
public class BaseballTeamService {
    @Autowired
    private BaseballTeamRepository repository;

    /**
     * 指定された野球チームの情報を検索する.
     *
     * @param id ID
     * @return 野球チーム情報
     */
    public BaseballTeam findById(Integer id){
        return repository.findById(id);
    }

}
