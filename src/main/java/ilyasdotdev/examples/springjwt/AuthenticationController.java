package ilyasdotdev.examples.springjwt;

import io.github.ilyasdotdev.spring.auth.jwt.JwtHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Muhammad Ilyas (m.ilyas@live.com)
 */
@RestController
@RequiredArgsConstructor
class AuthenticationController {

    private final JwtHelper jwtHelper;

    @GetMapping("/api/auth")
    public String auth() {

        JwtToken jwtToken = new JwtToken();
        jwtToken.setUsername("test user");
        jwtToken.setEmail("email@domain.com");
        jwtToken.setRoles(List.of("USER", "ADMIN"));

        return jwtHelper.serializeJwtToken(jwtToken);
    }

    @GetMapping("/api/data")
    public String data() {
        JwtToken token = (JwtToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(token.getUsername());
        System.out.println(token.getEmail());
        return "data";
    }
}
