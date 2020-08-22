package com.sabotinski.mongodbexample.customerservice.api.models;

import com.google.gson.Gson;

public class PaymentTerms {
    
    private String paymentMethodCode;
    private String discountDateFormula;
    private double discountPercent;

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getDiscountDateFormula() {
        return discountDateFormula;
    }

    public void setDiscountDateFormula(String discountDateFormula) {
        this.discountDateFormula = discountDateFormula;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((discountDateFormula == null) ? 0 : discountDateFormula.hashCode());
        long temp;
        temp = Double.doubleToLongBits(discountPercent);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((paymentMethodCode == null) ? 0 : paymentMethodCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PaymentTerms other = (PaymentTerms) obj;
        if (discountDateFormula == null) {
            if (other.discountDateFormula != null)
                return false;
        } else if (!discountDateFormula.equals(other.discountDateFormula))
            return false;
        if (Double.doubleToLongBits(discountPercent) != Double.doubleToLongBits(other.discountPercent))
            return false;
        if (paymentMethodCode == null) {
            if (other.paymentMethodCode != null)
                return false;
        } else if (!paymentMethodCode.equals(other.paymentMethodCode))
            return false;
        return true;
    }

    public PaymentTerms() {
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}