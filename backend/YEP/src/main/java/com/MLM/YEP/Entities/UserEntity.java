package com.MLM.YEP.Entities;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    private enum TYPE{
        ADMIN,
        PLAYER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String email ;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ReferralCodeEntity referralCode ;
//    private TYPE userType ;
}


//We have to maintain soft delete , created at , updated at , last login
