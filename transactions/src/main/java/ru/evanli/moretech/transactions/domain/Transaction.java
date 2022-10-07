package ru.evanli.moretech.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "transactions", name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "from_wallet_id")
    private Long fromWalletId;

    @Column(name = "from_user_id")
    private Long fromUserId;

    @Column(name = "to_wallet_id")
    private Long toWalletId;

    @Column(name = "to_user_id")
    private Long toUserId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "comment")
    private String comment;
}
