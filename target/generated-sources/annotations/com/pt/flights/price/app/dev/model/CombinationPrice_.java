package com.pt.flights.price.app.dev.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CombinationPrice.class)
public abstract class CombinationPrice_ {

	public static volatile SingularAttribute<CombinationPrice, Long> airLineId;
	public static volatile SingularAttribute<CombinationPrice, Long> combinationFlightId;
	public static volatile SingularAttribute<CombinationPrice, Long> inboundAirLineId;
	public static volatile SingularAttribute<CombinationPrice, Float> price;
	public static volatile SingularAttribute<CombinationPrice, String> usedAPI;
	public static volatile SingularAttribute<CombinationPrice, Boolean> directFlight;
	public static volatile SingularAttribute<CombinationPrice, Long> idCombinationFlight;
	public static volatile SingularAttribute<CombinationPrice, Long> outboundAirLineId;
	public static volatile SingularAttribute<CombinationPrice, LocalDateTime> registerDate;

	public static final String AIR_LINE_ID = "airLineId";
	public static final String COMBINATION_FLIGHT_ID = "combinationFlightId";
	public static final String INBOUND_AIR_LINE_ID = "inboundAirLineId";
	public static final String PRICE = "price";
	public static final String USED_AP_I = "usedAPI";
	public static final String DIRECT_FLIGHT = "directFlight";
	public static final String ID_COMBINATION_FLIGHT = "idCombinationFlight";
	public static final String OUTBOUND_AIR_LINE_ID = "outboundAirLineId";
	public static final String REGISTER_DATE = "registerDate";

}

