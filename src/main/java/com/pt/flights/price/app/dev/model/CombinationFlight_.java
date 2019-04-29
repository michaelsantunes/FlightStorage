package com.pt.flights.price.app.dev.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(value = CombinationFlight.class)
public abstract class CombinationFlight_ {

    public static volatile SingularAttribute<CombinationFlight, Long> idCombination;
    public static volatile SingularAttribute<CombinationFlight, String> weekDayInitial;
    public static volatile SingularAttribute<CombinationFlight, String> weekDayFinal;
    public static volatile SingularAttribute<CombinationFlight, Date> initialDate;
    public static volatile SingularAttribute<CombinationFlight, Date> finalDate;
    public static volatile SingularAttribute<CombinationFlight, AirPort> airPortTo;
    public static volatile SingularAttribute<CombinationFlight, AirPort> airPortFrom;
    public static volatile SingularAttribute<CombinationFlight, Boolean> myPreferences;
    public static volatile SingularAttribute<CombinationFlight, LocalDateTime> registerDate;
    public static volatile SingularAttribute<CombinationFlight, Integer> numberOfDays;
    public static volatile SingularAttribute<CombinationFlight, List<EmailCombination>> emailCombinations;
    public static volatile SingularAttribute<CombinationFlight, List<CombinationPrice>> combinationPrices;

    public CombinationFlight_() {
    }
}
