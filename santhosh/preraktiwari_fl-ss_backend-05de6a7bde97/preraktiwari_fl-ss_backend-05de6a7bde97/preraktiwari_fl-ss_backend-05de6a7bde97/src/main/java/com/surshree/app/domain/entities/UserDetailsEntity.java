package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_USER_DETAILS")
@NamedQueries(
        @NamedQuery(name = "UserDetailsEntity.findByUserName", query = "from UserDetailsEntity ud join fetch ud.user u where u.username = :userName")
)
public class UserDetailsEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_DETAILS_ID")
    private Long userDetailsId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(name = "PHONE_NUMBER")
    private String phoneNo;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "IS_EMAIL_VERIFIED")
    private String isEmailVerified;

    @Column(name = "IS_PHONE_VERIFIED")
    private String isPhoneVerified;

    @Column(name = "AADHAR_NO")
    private String aadharNo;

    @Column(name = "AADHAR_PHOTO")
    private UUID aadharPhoto;

    @Column(name = "PROFILE_VIDEO")
    private UUID profileVideo;

    @Column(name = "PROFILE_PICTURE")
    private UUID profilePicture;

    @Column(name = "PROFILE_DESC")
    private String getProfileDescription;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private AddressEntity address = new AddressEntity();


}
