package com.spring.demo.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.spring.demo.entity.RoomEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.model.MessageModel;
import com.spring.demo.repository.IRoomRepository;
import com.spring.demo.service.IMessagesService;
import com.spring.demo.service.IRoomService;
import com.spring.demo.service.IUserService;
import com.spring.demo.utils.DateUtil;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MessagesServiceImpl implements IMessagesService {
    @Autowired
    FirebaseInitializer db;
    @Autowired
    private IRoomService roomService;
    @Autowired
    private IRoomRepository roomRepository;
    @Autowired
    private IUserService userService;

    @Override
    public MessageModel addAndUpdate(String reply, String ip) {
        MessageModel model=new MessageModel();
        UsersEntity usersEntity = userService.getByUser();
        RoomEntity roomEntity = roomRepository.getRoom(usersEntity.getId(), ip);
        if (roomEntity != null) {
            int id = (roomEntity.getMessId() + 1);
            model.setCreatedBy(SecurityUtils.getName());
            Date date = new Date();
            model.setCreateDate(DateUtil.getDateConvert(date));
            model.setStatus(true);
            model.setId(id);
            model.setReply(reply);
            CollectionReference employeeCRTest = db.getFirebase()
                    .collection("room")
                    .document(ip)
                    .collection("mess");
            employeeCRTest.document(String.valueOf(model.getId())).set(model);
            roomRepository.updateRoom(id, model.getReply(), roomEntity.getId());
            return model;
        }
        return null;
    }

    @Override
    public List<MessageModel> getAllMessageByUser(String ip) {
        UsersEntity usersEntity = userService.getByUser();
        RoomEntity roomEntity = roomRepository.getRoom(usersEntity.getId(), ip);
        if (roomEntity != null) {
            List<MessageModel> messageModels = new ArrayList<>();
            CollectionReference message = db.getFirebase().collection("room")
                    .document(ip)
                    .collection("mess");
            ApiFuture<QuerySnapshot> querySnapshot = message.get();
            try {
                for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
                    MessageModel messageModel = doc.toObject(MessageModel.class);
                    messageModels.add(messageModel);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return messageModels;
        }
        return null;
    }

    @Override
    public void deleteMessage(String ip, int id) {
        UsersEntity usersEntity = userService.getByUser();
        RoomEntity roomEntity = roomRepository.getRoom(usersEntity.getId(), ip);
        if (roomEntity != null) {
            CollectionReference employeeCRTest = db.getFirebase()
                    .collection("room")
                    .document(ip)
                    .collection("mess");
            employeeCRTest.document(String.valueOf(id)).delete();
        }
    }
}
