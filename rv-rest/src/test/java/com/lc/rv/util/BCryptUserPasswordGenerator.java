package com.lc.rv.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Alexey.Koyro
 */
public class BCryptUserPasswordGenerator {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("BCryptUserPasswordGenerator is waiting 1 param: source password");
        }

        System.out.println("Source password: " + args[0]);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(args[0]);
        System.out.println("Encrypted passwrod: " + encryptedPassword);
    }
}
