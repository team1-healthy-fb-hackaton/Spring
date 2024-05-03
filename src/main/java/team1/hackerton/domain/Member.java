package team1.hackerton.domain;

import jakarta.persistence.*;
import lombok.*;
import team1.hackerton.domain.common.BaseEntity;
import team1.hackerton.domain.enums.RoleType;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String email;

    private String pwd;

    private String name;

    private RoleType role;

    public Member(String email, String pwd, String name) {
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.role = RoleType.ROLE_MEMBER;
    }
}
