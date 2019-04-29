package com.pt.flights.price.app.util.others;

import com.pt.flights.price.app.dev.model.AirPort;
import com.pt.flights.price.app.dev.service.AirPortImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class IataDefault {

    @Autowired
    AirPortImp airPortImp;

    public AirPort getAirPort() {
        return airPortImp.findIdByIata("OPO");
    }

}
