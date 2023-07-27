package SG.Poker.member.controller;

import SG.Poker.member.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oauth2", produces = "application/json")
@RequiredArgsConstructor
public class LoginController {
    private final CustomOAuth2UserService oAuth2UserService;

    @GetMapping("/callback/{provider}")
    public void oAuth2Login(@RequestParam OAuth2UserRequest oAuth2UserRequest) {
        oAuth2UserService.loadUser(oAuth2UserRequest);
    }

}
//http://localhost:8080/oauth2/authorize/google?redirect_uri=http://localhost:8080/oauth2/callback/google