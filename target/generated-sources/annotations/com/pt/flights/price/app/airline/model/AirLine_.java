package com.pt.flights.price.app.airline.model;

import com.pt.flights.price.app.dev.model.AirLine;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AirLine.class)
public abstract class AirLine_ {

	public static volatile SingularAttribute<AirLine, Long> idAirLine;
	public static volatile SingularAttribute<AirLine, String> code;
	public static volatile SingularAttribute<AirLine, String> name;

	public static final String ID_AIR_LINE = "idAirLine";
	public static final String CODE = "code";
	public static final String NAME = "name";

}

