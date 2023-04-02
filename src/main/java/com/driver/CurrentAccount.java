package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if (super.getBalance() < 5000) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isvalid = true;
        for (int i = 1; i < tradeLicenseId.length(); i++) {
            if (tradeLicenseId.charAt(i - 1) == tradeLicenseId.charAt(i)) {
                isvalid = false;
                break;
            }
        }
        if (isvalid) {
            return;
        } else {
            StringBuilder sb = new StringBuilder(tradeLicenseId);
            for (int i = 1; i < sb.length(); i += 2) {
                if (i + 1 >= sb.length() || sb.charAt(i) == sb.charAt(i + 1)) {
                    // Find the first different character from the current one
                    for (int j = i + 2; j < sb.length(); j++) {
                        if (sb.charAt(j) != sb.charAt(i)) {
                            // Swap characters
                            char temp = sb.charAt(i + 1);
                            sb.setCharAt(i + 1, sb.charAt(j));
                            sb.setCharAt(j, temp);
                            break;
                        }
                    }
                }
            }
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    throw new Exception("Valid License can not be generated");
                }
            }

            // Set the new license ID
            tradeLicenseId = sb.toString();
        }
    }
}
