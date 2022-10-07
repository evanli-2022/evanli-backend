package ru.evanli.moretech.transactions.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Locale;

@Data
@Entity
@Table(schema = "transactions", name = "wallet")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "kind")
    @Enumerated(EnumType.ORDINAL)
    private WalletType kind;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private Integer amount;

    @Getter
    public enum WalletType {
        PRIVATE, //0 in database
        CORPORATE; //1 in database
    }
}
