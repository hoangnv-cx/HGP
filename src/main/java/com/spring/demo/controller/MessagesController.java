package com.spring.demo.controller;

import com.spring.demo.model.MessageModel;
import com.spring.demo.service.IMessagesService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Messages Api")
public class MessagesController {
    @Autowired
    private IMessagesService messagesService;

    @GetMapping(value = "/message/{ip}")
    public List<MessageModel> getMessageByUser(@PathVariable("ip") @Parameter(example = "20210413105916704") String ip) {
        return messagesService.getAllMessageByUser(ip);
    }

    @PostMapping(value = "/message/send/{ip}/{reply}")
    @Schema(example = "1")
    public MessageModel sendMessage(@PathVariable("ip") @Parameter(example = "20210413105916704") String ip,
                                    @PathVariable("reply") @Parameter(example = "hello") String reply) {
        return messagesService.addAndUpdate(reply, ip);
    }

    @DeleteMapping(value = "/message/{room}/{id}")
    public void deleteMessage(@PathVariable("room") @Parameter(example = "4") String ip, @PathVariable("id") @Parameter(example = "333") int id) {
        messagesService.deleteMessage(ip, id);
    }
}
