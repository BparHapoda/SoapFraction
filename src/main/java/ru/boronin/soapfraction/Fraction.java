package ru.boronin.soapfraction;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@WebService(serviceName="FractionWS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "Fraction")
public class Fraction implements Serializable {
    private int denominator;
    private int numerator;
    private boolean right;
@WebMethod(operationName ="check")
    public boolean check(@WebParam(name = "numerator") int numerator,@WebParam(name = "denominator") int denominator) {
        if (denominator < 0) {
            denominator = -denominator;
        }
        if (numerator < 0) {
            numerator = -numerator;
        }
        if (numerator<denominator) {
            return true;
        } else return false;

    }
}
