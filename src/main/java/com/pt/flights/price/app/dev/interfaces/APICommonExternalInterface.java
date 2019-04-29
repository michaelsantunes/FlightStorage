package com.pt.flights.price.app.dev.interfaces;

import java.io.Serializable;

public interface APICommonExternalInterface<T1, T2,  T3 extends Serializable> {

    T3 buildRequestURL(T1 parameterOne, T3 urlParameter);
    T2 findFlightPrice();
}
