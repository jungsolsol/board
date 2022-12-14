package soccer.board.filter;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import soccer.board.domain.User;
import soccer.board.oauth.PrincipalDetails;
import com.auth0.jwt.JWT;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);

            PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        String jwttoken = JWT.create().withExpiresAt(new Date(System.currentTimeMillis() + (60 * 1000 * 10))).withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUsername()).sign(Algorithm.HMAC512(
                        "solsol"));

        response.addHeader("Authorization", "Bearer"+jwttoken);

    }


}

