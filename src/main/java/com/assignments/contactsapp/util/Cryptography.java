package com.assignments.contactsapp.util;

import com.assignments.contactsapp.exceptions.ApiException;
import com.assignments.contactsapp.exceptions.ErrorCodes;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.util.Map;


/**
 * Copyright 2015
 * Created by anurag on 22/4/15 03:28 AM.
 *
 * @author              anurag
 * @version             1.0
 *
 * utility class for all the cryptographic operations in the whole system.
 * This is final class and all the methods are static
 */
public final class Cryptography {
    /**
     * Indicates the default log rounds for bcrypt to hash the password
     */
    private static final int DEFAULT_LOG_ROUNDS = 8;
    /**
     * Default algorithm to generate pseudo random byte data
     */
    private static final String DEFAULT_ALGORITHM = "SHA1PRNG";
    private final static Logger logger = LoggerFactory.getLogger(Cryptography.class);

    /**
     * private consctructor to prevent instantiation
     */
    private Cryptography() {
    }

    /**
     * Hash the given password using bcrypt algorithm
     * This method should never return null value
     * @param   password                        plaintext password to hash
     * @return                                  hashed password
     * @throws  IllegalArgumentException        if password is not valid
     * @since   1.0
     */
    public static String hashPassword(String password) throws IllegalArgumentException {
        if(password == null || password.trim().length() < 1) {
            throw new IllegalArgumentException("password is invalid");
        }
        String hash = null;
        try {
            hash = BCrypt.hashpw(password, BCrypt.gensalt(DEFAULT_LOG_ROUNDS, SecureRandom.getInstance(DEFAULT_ALGORITHM)));
        } catch(NoSuchAlgorithmException nsae) {
            // this should never happen
            logger.error("Unexpected Exception", nsae);
        }
        return hash;
    }

    /**
     * Validate the given password against given hash.
     * @param   password                    The password to validate
     * @param   hash                        hash of the password to validate against
     * @return                              <code>TRUE</code> if the password is valid <CODE>FALSE</CODE> otherwise
     * @since   1.0
     */
    public static boolean validatePassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    /**
     * Decode the jwt token into a Map<String, Object> of key value pairs. Key will always be string and value can be any object
     * @param   token                       The token to decode
     * @param   secret                      secrect used to sign the token
     * @param   audience                    JWT audience
     * @return                              <code>TRUE</code> if the password is valid <CODE>FALSE</CODE> otherwise
     * @since   1.0
     */
    public static Map<String, Object> decodeJwtToken(String token, String secret, String audience) throws ApiException {
        try {
            return new JWTVerifier(secret, audience).verify(token);
        } catch (SignatureException se) {
            throw new ApiException(Response.Status.UNAUTHORIZED, se).addError(ErrorCodes.UNAUTHORIZED);
        } catch(NoSuchAlgorithmException | IOException | InvalidKeyException | JWTVerifyException | IllegalStateException ex) {
            throw new ApiException(Response.Status.UNAUTHORIZED,  ex).addError(ErrorCodes.INVALID_AUTHORIZATION_TOKEN);
        }
    }

    /**
     * Sign the Map<String, Object> of key value pairs into a jwt token
     * @param   claims                      JWT claims to sign
     * @param   secret                      secrect by which to sign the token
     * @return                              The generated jwt token
     * @since   1.0
     */
    public static String signJWT(Map<String, Object> claims, String secret) {
        JWTSigner signer = new JWTSigner(secret);
        return signer.sign(claims);
    }
}