package SG.Poker.member.entity;

import SG.Poker.member.oauth2.OAuth2UserInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String oauth2Id;
    private String email;
    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String activityYn;

    @Builder
    public Member(String name, String oauth2Id, String email, AuthProvider authProvider, Role role, String activityYn) {
        this.name = name;
        this.oauth2Id = oauth2Id;
        this.email = email;
        this.authProvider = authProvider;
        this.role = role;
        this.activityYn = activityYn;
    }

    public Member update(OAuth2UserInfo oAuth2UserInfo) {
        this.name = oAuth2UserInfo.getName();
        this.oauth2Id = oAuth2UserInfo.getOAuth2Id();

        return this;
    }
}
