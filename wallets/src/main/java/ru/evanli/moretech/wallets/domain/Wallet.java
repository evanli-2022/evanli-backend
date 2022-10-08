package ru.evanli.moretech.wallets.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "wallets", name = "wallet")
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

    @Column(name = "public_key")
    private String publicKey;

    @Column(name = "private_key")
    private String privateKey;

    @Getter
    public enum WalletType {
        PRIVATE, //0 in database
        CORPORATE; //1 in database
    }
}
