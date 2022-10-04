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

    @Column(name = "w_type")
//    @Enumerated(EnumType.STRING)
    @Convert(converter = WalletTypeConverter.class)
    private WalletType type;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private Integer amount;

    @Getter
    public static enum WalletType {
        PRIVATE,
        CORPORATE;
    }

    public static class WalletTypeConverter implements AttributeConverter<WalletType, String> {

        @Override
        public String convertToDatabaseColumn(WalletType walletType) {
            return walletType.name();
        }

        @Override
        public WalletType convertToEntityAttribute(String s) {
            return WalletType.valueOf(s.toUpperCase(Locale.ROOT));
        }
    }
}
