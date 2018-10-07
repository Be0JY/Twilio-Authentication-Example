package twil;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.lang3.RandomStringUtils;

public class main {
    // Find your Account Sid and Token at twilio.com/user/account
    public static String randomString() {

        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    public static final String ACCOUNT_SID = "ACe332c51268b739eee6da38239c195b36";
    public static final String AUTH_TOKEN = "ac0d0eb53faaabc236194df2bdcffbf6";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("4073356371"), new PhoneNumber("14075430148"),
                        "Ahoy from Twilio! " + randomString()).create();

        System.out.println(message.getSid());
    }
}

