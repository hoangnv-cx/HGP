package com.spring.demo.repository;

import com.spring.demo.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IRoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query(value = "Select * from room where user_id =:user_id OR user_client_id = :user_id AND status = 1", nativeQuery = true)
    List<RoomEntity> getAllRoomByUser(@Param("user_id") int userId);

    @Query(value = "Select * from room where ( user_id =:user_id OR user_client_id = :user_id ) AND ip = :ip", nativeQuery = true)
    RoomEntity getRoom(@Param("user_id") int userId, @Param("ip") String ip);

    @Query(value = "Select * from room where ( user_id =:user_id OR user_id =:user_client_id ) AND ( user_client_id = :user_client_id OR user_client_id = :user_id ) ", nativeQuery = true)
    RoomEntity getRoomByUser(@Param("user_id") int userId, @Param("user_client_id") int userClientId);

    RoomEntity findByIp(String ip);

    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET status = false WHERE ip = :ip", nativeQuery = true)
    void deleteRoomUser(@Param("ip") String ip);

    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET mess_id = :mess_id , mess_last = :mess_last WHERE id = :id", nativeQuery = true)
    void updateRoom(@Param("mess_id") int mess_id, @Param("mess_last") String mess_last, @Param("id") int id);

}
