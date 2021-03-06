package com.flextrade.jfixture.behaviours.autoproperty;

import com.flextrade.jfixture.specifications.Specification;
import com.flextrade.jfixture.utility.SpecimenType;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

class DefaultAutoPropertySpecification implements Specification {

    private final HashSet<Type> typeBlackList = new HashSet<Type>() {{
        this.add(SpecimenType.of(Date.class)); // Date is mutable, but handled by the default engine. We don't want the auto property behaviour to affect Dates
        this.add(SpecimenType.of(Calendar.class)); // Calendar is mutable, but handled by the default engine. We don't want the auto property behaviour to affect Calendars
    }};

    @Override
    public boolean isSatisfiedBy(Object request) {
        return request instanceof Type && !typeBlackList.contains(request);
    }
}
