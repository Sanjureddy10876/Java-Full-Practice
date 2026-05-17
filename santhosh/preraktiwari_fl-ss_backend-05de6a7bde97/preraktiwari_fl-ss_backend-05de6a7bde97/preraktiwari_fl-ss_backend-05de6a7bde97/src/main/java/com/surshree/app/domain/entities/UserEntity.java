package com.surshree.app.domain.entities;

import com.surshree.app.CacheConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_USER")
public class UserEntity extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "USER_NAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_TYPE", nullable = false)
    private String userType;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME", nullable = true)
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DOB", nullable = false)
    private Date dob;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "IS_APPROVED", nullable = false)
    private String isApproved;

    @Column(name = "IS_ACTIVE", nullable = false)
    private String isActive;

    @Column(name = "FAILED_LOGIN_ATTEMPTS", nullable = false)
    private int failedLoginAttempts;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private UserDetailsEntity details;

    @OneToMany( orphanRemoval = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="T_MPG_USER_ROLE",
                joinColumns = @JoinColumn(name = "USER_ID"),
                inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<MstRoleEntity> roleMapping = new HashSet<>();

    @Transient
    private boolean isUserRegistered;

    @Transient
    private String[] roles;

    @Transient
    private String[] functions;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        roles = this.getRoleMapping().stream().map(r -> r.getRoleName()).toArray(String[]::new);

        List<String> funcs = new ArrayList<>();

        this.getRoleMapping()
                .forEach(
                        r -> r.getFunctions().forEach(f -> funcs.add(f.getFuncName()))
                );
        functions = funcs.stream().toArray(String[]::new);

        List<GrantedAuthority> auths = Stream.of(roles).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        auths.addAll(Stream.of(functions).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        return auths;
    }

    public boolean isAccountNonExpired() {
        return "1".equals(this.getIsActive());
    }

    public boolean isAccountNonLocked() {
        return 3 > this.getFailedLoginAttempts();
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return "1".equals(this.getIsActive());
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", roleMapping=" + roleMapping +
                ", isUserRegistered=" + isUserRegistered +
                ", objectRef=" + super.toString() +
                '}';
    }

    public Set<MstRoleEntity> getRoleMapping(){
        return this.roleMapping;
    }

    @Cacheable(value = CacheConstants.CACHE_ROLES)
    public void setRoleMapping(Set<MstRoleEntity> roles){
        this.roleMapping = roles;
    }
}
