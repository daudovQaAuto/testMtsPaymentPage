package commonAndConstant;

public class Constant {
    public static class TimeOutVariables{
        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 10;
    }
    public static class Urls {
        public static final String MOBILE_PAYMENT_URL = "https://payment.mts.ru/pay/phone";
    }

    public static class MobileTopUpTestData{
        public static final String MOBILE_PAYMENT_PHONE_NUMBER = "9151611712";
        public static final String MOBILE_PAYMENT_CARD = "5189018580519605";
        public static final String MOBILE_PAYMENT_CARD_EXP_DATE = "0124";
        public static final String MOBILE_PAYMENT_CARD_CVV = "123";
        public static final String MOBILE_PAYMENT_VOID_FIELD = "Это поле необходимо заполнить";

    }
}

