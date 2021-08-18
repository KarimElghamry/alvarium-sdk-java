package com.alvarium.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EncoderTest {
  private final byte[][] bytes = { { (byte) 0xAA, (byte) 0xFF, (byte) 0x1 },
      {(byte) 0xB, (byte) 0x0, (byte) 0x11, (byte)0x4F} };
  private final String[] hex = {"AAFF01", "0B00114F"};

  @Test
  public void bytesToHexShouldReturnDoubleLength() throws NoSuchAlgorithmException{
    for (int i = 0; i < 20; i++) {
      byte[] data = new byte[i];
      SecureRandom.getInstanceStrong().nextBytes(data);
      String hexResult = Encoder.bytesToHex(data);
      assertEquals(data.length * 2, hexResult.length());
    }
  }

  @Test
  public void bytesToHexShouldPass() {
    for (int i = 0; i < bytes.length; i++) {
      final String hexResult = Encoder.bytesToHex(bytes[i]);
      assertEquals(hex[i], hexResult);
    }
  }
}
