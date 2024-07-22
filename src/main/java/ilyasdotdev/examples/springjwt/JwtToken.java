package ilyasdotdev.examples.springjwt;

import io.github.ilyasdotdev.spring.auth.jwt.Token;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * @author Muhammad Ilyas (m.ilyas@live.com)
 */
@Data
class JwtToken implements Token {

    private String username;
    private String email;
    private List<String> roles;

    @Override
    public Collection<String> getRoles() {
        return roles;
    }
}
