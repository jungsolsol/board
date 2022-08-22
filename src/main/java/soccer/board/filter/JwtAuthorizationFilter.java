package soccer.board.filter;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import soccer.board.config.SecurityConfig;
import soccer.board.domain.User;
import soccer.board.oauth.PrincipalDetails;
import soccer.board.repository.User.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.auth0.jwt.JWT;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("인증이나 권한이 필요한 주소 요청됨");

        String header = request.getHeader("Authorization");
        if(header == null || !header.startsWith("Bearer")) {
            chain.doFilter(request,response);
        }
        String jwtToken = header.replace("Bearer", "");
        String username = JWT.require(Algorithm.HMAC512(
                "solsol")).build().verify(jwtToken).getClaim("username").asString();
        if(username != null) {
            User userEntity = userRepository.forConfigurationFindByUsername(username);

            PrincipalDetails principalDetails = new PrincipalDetails(userEntity);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    principalDetails, null, principalDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request,response);

        }


            super.doFilterInternal(request, response, chain);
    }
}
