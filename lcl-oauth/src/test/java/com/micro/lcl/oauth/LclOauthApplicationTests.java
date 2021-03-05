package com.micro.lcl.oauth;

import com.micro.lcl.oauth.service.SecurityService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
class LclOauthApplicationTests {
    @Autowired
    private SecurityService service;

    private Authentication authorization;

    @Before
    public void init() {
        authorization = new UsernamePasswordAuthenticationToken("app","123456");
    }

    @After
    public void destory() {
        SecurityContextHolder.clearContext();
    }
    @Test
    void contextLoads() {

    }

    @Test
    public void secure() {
        assertThatExceptionOfType(AuthenticationException.class)
                .isThrownBy(() -> this.securityService.secure());
    }

    @Test
    public void authenticated() {
        SecurityContextHolder.getContext().setAuthentication(this.authentication);
        assertThat("Hello Security").isEqualTo(this.securityService.secure());
    }

    @Test
    public void preauth() {
        SecurityContextHolder.getContext().setAuthentication(this.authentication);
        assertThat("Hello World").isEqualTo(this.securityService.authorized());
    }

    @Test
    public void denied() {
        SecurityContextHolder.getContext().setAuthentication(this.authentication);
        assertThatExceptionOfType(AccessDeniedException.class)
                .isThrownBy(() -> this.securityService.denied());
    }

}
