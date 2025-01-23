# Receipt Processor Application

## Run Instructions

### Prerequisites: 
* Docker
* Java 17

### To Run Locally
1. `mvn clean package`
2. `docker build -t receipt-processor .`
3. `docker run -p 8080:8080 receipt-processor`

### Sample Requests
<sup>(I used Thunder Client to test the endpoints)</sup>

POST Request:
```
POST http://localhost:8080/receipts/process
body: {
  "retailer": "Target",
  "purchaseDate": "2022-01-01",
  "purchaseTime": "13:01",
  "items": [
    {
      "shortDescription": "Mountain Dew 12PK",
      "price": "6.49"
    },{
      "shortDescription": "Emils Cheese Pizza",
      "price": "12.25"
    },{
      "shortDescription": "Knorr Creamy Chicken",
      "price": "1.26"
    },{
      "shortDescription": "Doritos Nacho Cheese",
      "price": "3.35"
    },{
      "shortDescription": "   Klarbrunn 12-PK 12 FL OZ  ",
      "price": "12.00"
    }
  ],
  "total": "35.35"
}
```
POST Response:
```
200 OK
{
  "id": "0f1567f1-49db-475f-b0e5-c4b62ba566c7"
}
```

GET Request:
`GET http://localhost:8080/receipts/76b8e8b8-b476-48d4-870f-c04d7f9fd613/points`

GET Response:
```
200 OK
{
  "points": 28
}
```


## About
### Tech Stack: Java, Spring Boot, Maven, Docker

Thanks for Reviewing!
