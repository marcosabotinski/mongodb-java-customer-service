# mongodb-java-customer-service
example microservice that demonstrate how to leverage the mongodb java driver

## Create Customers

### B2B Customer
```bash
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/customers -d '
{
    "customerType": "B2B",
    "customerid": "4711",
    "email": "info@sample-company.com",
    "addresses": [
        {
            "street": "Sample Street 1",
            "postcode": "12345",
            "city": "Musterstadt",
            "countryCode": "CH"
        }
    ],
    "companyName": "Sample Company",
    "contactPersonName": "Max Mueller",
    "rating": 5,
    "paymentTerms": [
        {
            "paymentMethod": "Credit Card",
            "discountDateFormula": "2 days",
            "discountPercent": 1.5
        },
        {
            "paymentMethod": "Bank Transfer",
            "discountDateFormula": "10 days",
            "discountPercent": 2
        }
    ]
}'
```

### B2C Customer
```bash
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/customers -d '
{
    "customerType": "B2C",
    "customerid": "0815",
    "firstname": "Max",
    "lastname": "Mustermann",
    "email": "max@gmail.com",
    "addresses": [
        {
            "street": "Example Place 2",
            "postcode": "12345",
            "city": "Musterstadt",
            "countryCode": "CH"
        }
    ],
    "loyaltyLevel": 95
}'
```
## Show Customers
Open in your browser: `http://localhost:8080/customers`
