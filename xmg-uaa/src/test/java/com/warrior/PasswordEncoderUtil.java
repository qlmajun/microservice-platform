package com.warrior;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author mj
 * @date 2020/10/22
 */
public class PasswordEncoderUtil {

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("test123456"));
  }
}
