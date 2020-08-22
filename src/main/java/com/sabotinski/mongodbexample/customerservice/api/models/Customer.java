package com.sabotinski.mongodbexample.customerservice.api.models;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.gson.Gson;

//Json attributes are used for handling subclasses in PostMapping - not MongoDB but spring/jackson related
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "customerType")
@JsonSubTypes({@JsonSubTypes.Type(value = B2CCustomer.class, name = "B2C"),
               @JsonSubTypes.Type(value = B2BCustomer.class, name = "B2B")})
//only the Bson attribute is needed to handle deserialization for MongoDB
@BsonDiscriminator(key="customerType", value="GENERIC")
public abstract class Customer {
    
    private String customerid;
    private String email;
    private String customerType;
    private List<Address> addresses;
    private boolean isActive;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
        result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
        result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (isActive ? 1231 : 1237);
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
        Customer other = (Customer) obj;
        if (addresses == null) {
            if (other.addresses != null)
                return false;
        } else if (!addresses.equals(other.addresses))
            return false;
        if (customerType == null) {
            if (other.customerType != null)
                return false;
        } else if (!customerType.equals(other.customerType))
            return false;
        if (customerid == null) {
            if (other.customerid != null)
                return false;
        } else if (!customerid.equals(other.customerid))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (isActive != other.isActive)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}