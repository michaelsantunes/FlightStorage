package com.pt.flights.price.app.util.others;

import com.pt.flights.price.app.dev.service.CombinationFlightImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class Common {

    @Autowired
    CombinationFlightImp combinationFlightImplements;

    /**
     * Create code to reference flights from with flights to. Wait one half second because the time is used to
     * combine with ID.
     * @param idCombination
     * @return MD5 Code.
     * @throws NoSuchAlgorithmException
     */
    public String createCodeFlightFromTo(Long idCombination) throws NoSuchAlgorithmException {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String code = String.valueOf(idCombination + new Date().getTime());
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(code.getBytes());
        return DatatypeConverter.printHexBinary(messageDigest.digest());
    }

    public double getPercentage(double percentage, double value) throws Exception {
        return (percentage / 100) * value;
    }
}
