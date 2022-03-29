package com.spring.demo.service;

import com.spring.demo.model.MessageModel;

import java.util.List;

public interface IMessagesService {
    MessageModel addAndUpdate(String reply, String ip);

    List<MessageModel> getAllMessageByUser(String ip);

    void deleteMessage(String ip, int id);
}
