package ru.boronin.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ru.boronin.soapfraction.Fraction;
@WebService
public interface CalcService {
    @WebMethod
    public Fraction check(int denumerator, int numerator);
    @WebMethod
    public Fraction reduction(int numerator, int denominator);
    @WebMethod
    public Fraction plus(int numerator1, int denominator1, int numerator2, int denominator2);
    @WebMethod
    public Fraction minus(int numerator1, int denominator1, int numerator2, int denominator2);
    @WebMethod
    public Fraction mult(int numerator1, int denominator1, int numerator2, int denominator2);
    @WebMethod
    public Fraction div(int numerator1, int denominator1, int numerator2, int denominator2);
}