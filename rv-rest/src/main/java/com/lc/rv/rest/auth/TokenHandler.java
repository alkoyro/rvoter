package com.lc.rv.rest.auth;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey.Koyro
 */
public class TokenHandler {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_ROLE = "role";

    private String secret;

    public TokenHandler(String secret) {
        this.secret = secret;
    }

    public User getUserFromToken(String token) {
        //TODO add exception handling
        try {
            Map<String, Object> payload = new JWTVerifier(secret).verify(token);
            String username = (String) payload.get(KEY_USERNAME);
            String role = (String) payload.get(KEY_ROLE);


            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);

            return new User(username, "", Arrays.asList(grantedAuthority));
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (InvalidKeyException e) {
            return null;
        } catch (IOException e) {
            return null;
        } catch (SignatureException e) {
            return null;
        } catch (JWTVerifyException e) {
            return null;
        }
    }

    public String generateToken(Authentication authentication) {
        JWTSigner jwtSigner = new JWTSigner(secret);
        Map<String, Object> payload = new HashMap<String, Object>();

        String role = new ArrayList<GrantedAuthority>(authentication.getAuthorities()).get(0).getAuthority();
        payload.put(KEY_USERNAME, authentication.getPrincipal());
        payload.put(KEY_ROLE, role);
        
        return jwtSigner.sign(payload);
    }
}
