package ru.evanli.moretech.wallets.domain.dto;

import lombok.Data;

@Data
public class MoveDto {
    private Long fromWalletId;
    private Long toUserId;
    private int amount;
    private String comment;
}
