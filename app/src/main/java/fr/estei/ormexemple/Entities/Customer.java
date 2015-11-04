package fr.estei.ormexemple.Entities;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

/**
 * Created by mdepe on 21/10/2015.
 */
public class Customer extends SugarRecord<Customer> {
    String firstName;
    String lastName;

    @Ignore
    String FullName;

    public String getFullName() {
        return firstName + " " +  lastName;
    }


}
