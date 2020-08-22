package com.sabotinski.mongodbexample.customerservice.api.models;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import com.google.gson.Gson;

@BsonDiscriminator(key="customerType", value="B2C")
public class B2CCustomer extends Customer {
    
    private String firstname;
    private String lastname;
    private int loyaltyLevel;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getLoyaltyLevel() {
        return loyaltyLevel;
    }

    public void setLoyaltyLevel(int loyaltyLevel) {
        this.loyaltyLevel = loyaltyLevel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + loyaltyLevel;
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
        B2CCustomer other = (B2CCustomer) obj;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (loyaltyLevel != other.loyaltyLevel)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public B2CCustomer() {
    }
     
}