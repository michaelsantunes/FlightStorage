package com.pt.flights.price.app.airport.model;

import com.pt.flights.price.app.dev.model.AirPort;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AirPort.class)
public abstract class AirPort_ {

	public static volatile SingularAttribute<AirPort, Boolean> flightFrom;
	public static volatile SingularAttribute<AirPort, String> iata;
	public static volatile SingularAttribute<AirPort, Integer> idAirPort;
	public static volatile SingularAttribute<AirPort, String> name;
	public static volatile SingularAttribute<AirPort, String> icao;
	public static volatile SingularAttribute<AirPort, Integer> cityId;

	public static final String FLIGHT_FROM = "flightFrom";
	public static final String IATA = "iata";
	public static final String ID_AIR_PORT = "idAirPort";
	public static final String NAME = "name";
	public static final String ICAO = "icao";
	public static final String CITY_ID = "cityId";

}

