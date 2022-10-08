package ru.evanli.moretech.wallets.domain.dto;

import lombok.Data;

@Data
public class TransferData {
    private Long toUserId;
    private Double amount;
    private String comment;
}
