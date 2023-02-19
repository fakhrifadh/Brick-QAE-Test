package utilities;

import java.time.Instant;
import net.datafaker.Faker;

public class FakerUtil extends Faker {
    public String getEpoch() {
        return Long.toString(Instant.now().getEpochSecond());
    }

    public String randomEmail() {
        return internet().emailAddress();
    }

    public String randomPhoneNumber() {
        return this.getEpoch();
    }

}
