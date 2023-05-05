package ru.boronin.service;

import jakarta.jws.WebService;
import ru.boronin.soapfraction.Fraction;
@WebService(endpointInterface = "ru.boronin.service.CalcService" ,serviceName = "CalcService")
public class CalcServiceImpl implements CalcService{
    @Override
    public Fraction check(int numerator, int denominator) {
        if (denominator < 0) {
            denominator = -denominator;
        }
        if (numerator < 0) {
            numerator = -numerator;
        }
        if (numerator<denominator) {
            return Fraction.builder().denominator(denominator).numerator(numerator).right(true).build();
        } else return
                Fraction.builder().denominator(denominator).
                        numerator(numerator).right(false).build();

    }

    @Override
    public Fraction reduction(int numerator, int denominator) {
        int bigCden=bigCden(numerator,denominator);
        numerator=numerator/bigCden;
        denominator=denominator/bigCden;
        return new Fraction(numerator,denominator,false);
    }

    @Override
    public Fraction plus(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator=numerator1*denominator2+numerator2*denominator1;
        int denominator=        denominator1*denominator2;
        return reduction(numerator,denominator);
    }

    @Override
    public Fraction minus(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator=numerator1*denominator2-numerator2*denominator1;
        int denominator=        denominator1*denominator2;
        return reduction(numerator,denominator);
    }

    @Override
    public Fraction mult(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator=numerator1*numerator2;
        int denominator=denominator1*denominator2;
        return reduction(numerator,denominator);
    }

    @Override
    public Fraction div(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numerator=numerator1*denominator2;
        int denominator=denominator1*numerator2;
        return reduction(numerator,denominator);
    }

    public static int bigCden(int x, int y) {
        return y == 0 ? x : bigCden(y, x % y);
    }

}