package twil;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.commons.lang3.RandomStringUtils;

public class TwilioSender {
    static String generatedString = "";

    // Find your Account Sid and Token at twilio.com/user/account
    public static String randomString() {

        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = false;
        generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    public static final String ACCOUNT_SID = "ACe332c51268b739eee6da38239c195b36";
    public static final String AUTH_TOKEN = secrets.key;

    public static void sendText(String phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String rand_string = randomString();
        Message message = Message
                .creator(new PhoneNumber(phoneNumber), new PhoneNumber("14075430148"),
                        "Ahoy from Twilio! " + rand_string).create();

        System.out.println(message.getSid());
    }
}

