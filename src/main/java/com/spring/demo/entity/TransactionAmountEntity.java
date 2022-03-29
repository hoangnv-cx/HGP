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
@Table(name = "transactions", schema = "heroku_8824700dd65d660")
public class TransactionAmountEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "1", type = "Integer")
    private int id;
    @Schema(example = "Transaction money", type = "String")
    private String description;

    @Column(name = "amount")
    @Schema(example = "2000", type = "double")
    private double amount;

    @ManyToOne()
    @JoinColumn(name = "card_received", referencedColumnName = "id")
    private CreditCardEntity cardReceived;

    @ManyToOne()
    @JoinColumn(name = "card_send", referencedColumnName = "id")
    private CreditCardEntity cardSend;

}
