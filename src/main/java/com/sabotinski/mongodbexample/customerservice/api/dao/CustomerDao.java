package com.sabotinski.mongodbexample.customerservice.api.dao;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sabotinski.mongodbexample.customerservice.api.models.B2BCustomer;
import com.sabotinski.mongodbexample.customerservice.api.models.B2CCustomer;
import com.sabotinski.mongodbexample.customerservice.api.models.Customer;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

    private static String CUSTOMER_COLLECTION_NAME = "customers";
    private MongoCollection<Customer> customerCollection;
    private CodecRegistry pojoCodecRegistry;

    private final CodecProvider customerCodecProvider = PojoCodecProvider.builder()
            // Register all classes that can be used for automatic mapping from MongoDB to
            // POJOs
            .register(Customer.class.getPackage().getName())
            // As we use custom discriminators (customerType=B2C/B2B) and the
            // discriminators are loaded in a lazy fashion, we need to register those
            // classes explicitly
            .register(B2CCustomer.class).register(B2BCustomer.class).build();

    @Autowired
    public CustomerDao(MongoClient mongoClient, @Value("${db.databasename}") String databaseName) {
        this.pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(customerCodecProvider),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        customerCollection = mongoClient.getDatabase(databaseName)
                .getCollection(CUSTOMER_COLLECTION_NAME, Customer.class).withCodecRegistry(pojoCodecRegistry);
    }

    public List<Customer> getCustomers() {
        var customers = new ArrayList<Customer>();
        customerCollection.find().iterator().forEachRemaining(customers::add);
        return customers;
    }

    public Customer getCustomer(String customerId) {
        var customer = customerCollection.find(eq("customerid", customerId)).first();
        return customer;
    }

    public void createCustomer(Customer newCustomer) {
        customerCollection.insertOne(newCustomer);
    }
}