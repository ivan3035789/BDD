package data;

import lombok.Value;

public class Helper {

    private Helper() {
    }

    public static String[] cards = {"5559 0000 0000 0001", "5559 0000 0000 0002"};

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static int transferAmount(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }
}