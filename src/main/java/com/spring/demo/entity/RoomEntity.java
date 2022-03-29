package com.spring.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class RoomEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "1", required = true)
    private Integer id;
    @Schema(example = "1", required = true)
    private Byte status;
    @Schema(example = "1", required = true)
    private String ip;
    @Column(name = "mess_last")
    @Schema(example = "hello", required = true)
    private String messLast;
    @Column(name = "mess_id")
    @Schema(example = "1", required = true)
    private int messId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity userSend;

    @OneToOne
    @JoinColumn(name = "user_client_id")
    private UsersEntity userTake;

}
