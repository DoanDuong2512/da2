package com.duongthuy.project.util;

import java.util.Random;

public class VoucherCodeGenerator {
    public static String generateVoucherCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder voucherCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            voucherCode.append(characters.charAt(index));
        }

        return voucherCode.toString();
    }
}
