package com.spring.demo.controller;

import com.spring.demo.entity.MyWorkEntity;
import com.spring.demo.model.MyWordResponse;
import com.spring.demo.model.StatusResponse;
import com.spring.demo.service.IMyWordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobs")
@Tag(name = "My Word Api")
public class MyWordController {
    @Autowired
    IMyWordService wordService;

    @GetMapping("/my-word")
    public List<MyWorkEntity> viewAllMyJob() {
        return wordService.findAllMyWord();
    }

    @PostMapping("/my-word")
    public MyWorkEntity addMyJob(@RequestBody MyWordResponse myWork) {
        return wordService.addMyWord(wordService.convertFromMyWordResponse(myWork));
    }

    @PutMapping("/my-word")
    public MyWorkEntity updateMyJob(@RequestBody MyWorkEntity myWork) {
        return wordService.addMyWord(myWork);
    }

    @PutMapping("/my-word/status")
    public MyWorkEntity updateStatusMyJob(@RequestBody StatusResponse statusResponse) {
        return wordService.updateByIdAndStatus(statusResponse.getEntityId(), statusResponse.getStatus());
    }

    @DeleteMapping("/my-word")
    public List<MyWorkEntity> removeMyJob(@RequestBody int[] id) {
        wordService.DeleteById(id);
        return wordService.findAllMyWord();
    }

}
