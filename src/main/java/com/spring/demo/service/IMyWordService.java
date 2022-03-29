package com.spring.demo.service;

import com.spring.demo.entity.MyWorkEntity;
import com.spring.demo.model.MyWordResponse;

import java.util.List;

public interface IMyWordService {
    List<MyWorkEntity> findAllMyWord();

    MyWorkEntity findMyWordById(int id);

    MyWorkEntity addMyWord(MyWorkEntity myWorkEntity);

    MyWorkEntity updateByIdAndStatus(int id, byte status);

    void DeleteById(int[] id);

    MyWorkEntity convertFromMyWordResponse(MyWordResponse wordResponse);
}
