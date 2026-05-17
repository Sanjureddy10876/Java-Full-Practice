package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_MPG_USER_ROLE")
@NamedQueries(
        @NamedQuery(name = "UserRoleMpgEntity.findByUserId", query = "from UserRoleMpgEntity ur join ur.role r where ur.userId = :userId")
)
public class UserRoleMpgEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ROLE_ID")
    private Long userRoleId;

    @Column(name = "USER_ID")
    private Long userId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private MstRoleEntity role;
}
