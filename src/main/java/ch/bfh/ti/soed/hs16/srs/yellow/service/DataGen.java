package ch.bfh.ti.soed.hs16.srs.yellow.service;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import static io.codearte.jfairy.producer.person.PersonProperties.male;
import static io.codearte.jfairy.producer.person.PersonProperties.minAge;

/**
 * Created by danbeloff on 23.11.16.
 */
public interface DataGen {
    public default void generateInitialData() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        System.out.println(person.fullName());
        System.out.println(person.email());
        System.out.println(person.telephoneNumber());

        Person adultMale = fairy.person(male(), minAge(21));
        System.out.println(adultMale.isMale());
        System.out.println(adultMale.dateOfBirth());
    }

    ;
}
