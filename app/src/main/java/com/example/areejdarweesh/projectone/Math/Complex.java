package com.example.areejdarweesh.projectone.Math;

/**
 * Created by Areej darweesh on 4/25/2019.
 */

public class Complex {
    private final double re;   // القسم الحقيقي
    private final double im;   // القسم التخيلي

    public Complex(double real, double imag) {
        re = real;
        im = imag;
        //    System.out.println(re+"  "+im+"i"+"sssdd");
    }

    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im < 0) return re + " - " + (-im) + "i";
        //  System.out.println(re+"  "+im+"i"+"ddd");
        return re + " + " + im + "i";
    }

    // جمع العدد مع عدد اخر
    public Complex plus(Complex b) {
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // طرع من العدد عدد اخر
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // ضرب العدد بعدد اخر
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    //ضرب العدد بقيمه
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // مرافق العدد
    public Complex conjugate() {
        return new Complex(re, -im);
    }

    // مقلوب العدد
    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    // القسم الحقيقي لحال او التخيلي
    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    // قسمة a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // التحويل للشكل الاسي
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    public Complex tan() {
        return sin().divides(cos());
    }


    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }

}
