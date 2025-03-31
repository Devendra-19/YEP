package com.MLM.YEP.Entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "referral_codes")
public class ReferralCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String code ;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", unique = true)
    private UserEntity user ;
}
