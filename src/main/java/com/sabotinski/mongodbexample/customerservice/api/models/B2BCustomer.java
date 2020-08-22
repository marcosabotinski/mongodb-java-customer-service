package com.sabotinski.mongodbexample.customerservice.api.models;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import java.util.List;

import com.google.gson.Gson;

@BsonDiscriminator(key="customerType", value="B2B")
public class B2BCustomer extends Customer {
    
    private String companyName;
    private String contactPersonName;
    private int rating;
    private List<PaymentTerms> paymentTerms;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((contactPersonName == null) ? 0 : contactPersonName.hashCode());
        result = prime * result + ((paymentTerms == null) ? 0 : paymentTerms.hashCode());
        result = prime * result + rating;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        B2BCustomer other = (B2BCustomer) obj;
        if (companyName == null) {
            if (other.companyName != null)
                return false;
        } else if (!companyName.equals(other.companyName))
            return false;
        if (contactPersonName == null) {
            if (other.contactPersonName != null)
                return false;
        } else if (!contactPersonName.equals(other.contactPersonName))
            return false;
        if (paymentTerms == null) {
            if (other.paymentTerms != null)
                return false;
        } else if (!paymentTerms.equals(other.paymentTerms))
            return false;
        if (rating != other.rating)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public B2BCustomer() {
    }
}