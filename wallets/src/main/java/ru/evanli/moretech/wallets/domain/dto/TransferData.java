package ru.evanli.moretech.wallets.domain.dto;

import lombok.Data;

@Data
public class TransferData {
    private Long fromUserId;
    private Long toUserId;
    private Double amount;
    private String comment;
}
