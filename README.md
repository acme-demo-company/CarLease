# CarLeaseAPI

Database : 
In Memory H2 database

**CarLeaseAPI Run Instructions**

1.  Check-out CarLeaseApi App from https://github.com/Deepesh04/CarLeaseAPI
2.  Import as Maven Project in STS 
3.  Build CarLeaseApi application - Run As -> Maven Build
4.  Start CarLeaseApi application - Run As -> SpringBoot App

**Service Call Instructions with UseCases**

**Making Secure Call - Instructions**

Since Security is enabled for this application, we need to gather JWT token before making any API call.

1. Send POST Request to http://localhost:8080/user with below mentioned properties
![image](https://user-images.githubusercontent.com/100697540/156183682-5548e20f-c632-43d4-bb3a-c77c0905ae82.png)

2. From Response we can obtain JWT token
![image](https://user-images.githubusercontent.com/100697540/156184602-ee9aadcf-ddaf-4442-ad7b-e824de6335cd.png)

3. Now this token can be used before making any CarLeaseAPI call like below : 
![image](https://user-images.githubusercontent.com/100697540/156185037-e727725d-e839-476d-8c53-c77bdcfb8f98.png)

**Usecases for Customer**

1. Check customer data exists in database : 

    API Call : 
    
      Method : GET
      
      URL : http://localhost:8080/customers/{email}
      
      Body : None
      
      Response : 
      
      {
          "custId": "YDZANRuU0N4ym6n",
          "firstName": "Deepesh",
          "lastName": "Mishra",
          "email": "deepeshmishra@gmail.com"
      }

2. If customer not exist, then register the customer 
 
    API Call : 
    
      Method : POST
      
      URL : http://localhost:8080/customers
      
      Body : 
        {
         "firstName" : "Divya",
         "lastName" : "Mishra",
         "email" : "dmishra@gmail.com",
         "street" : "Parkzichtlaan",
         "houseNumber" : 242,
         "zipCode" : "3544MN",
         "place" : "Utrecht",
         "phoneNumber" : "0644460636"
        } 
        
  3.  If customer wants to update his/her address
  
      API Call : 
    
      Method : PUT
      
      URL : http://localhost:8080/customers/{cust-id}
      
      Body : 
        {
         "street" : "Brink",
         "houseNumber" : 182,
         "zipCode" : "1188NH",
         "place" : "Amstelveen"
        } 

4. If customer wants to de-register 
     API Call : 
    
      Method : DELETE
      
      URL : http://localhost:8080/customers/{cust-id}
      
      
 **Usecases for CAR and Calculate LeaseRate **
 
 1. Register New CAR
 
 API Call : 
    
      Method : POST
      
      URL : http://localhost:8080/cars
      
      Body : 
      
      {
        "make": "Hundai",
        "model": "Sedan",
        "version": "Sports",
        "noOfDoors": 4,
        "co2Emission": 70,
        "grossPrice": 10000,
        "netPrice": 6000,
        "milageKmsPerYear": 32000
       }
      
      Response : 
      
      {
          "carId": "62XBPLt9l7FbAs2",
          "make": "Hundai",
          "model": "Sedan",
          "version": "Sports",
          "netPrice": 6000.0,
          "milageKmsPerYear": 32000.0
      }
      
2 Get Car Details By Id  

 API Call : 
    
      Method : GET
      
      URL : http://localhost:8080/cars/{car-id}
      
      Response : 
      {
          "carId": "IvsNg2Mr6PaejmT",
          "make": "BMW",
          "model": "Sedan",
          "version": "X5",
          "netPrice": 19000.0,
          "milageKmsPerYear": 42000.0
      }
      
3. Update CAR - net price, milage, co2Emission  

API Call : 
    
      Method : PUT
      
      URL : http://localhost:8080/cars/{car-id}
      
      Body :
      
      {
          "co2Emission": 80,
          "netPrice": 5000,
          "milageKmsPerYear": 32000
      }
      
4.** Calculate CarLease Rate  for particular CAR.**
   Logic is to get Mileage and netprice from car record, and parameter like interest rate and duration will be provided by broker as these parameter are subject to change.
   
   Method : POST
      
      URL : http://localhost:8080/cars/{car-id}/calculate-leaserate
      
      Body :
      {
          "duration" : 60,
          "interestRate" : 4.5
      }
      
      Response : 
        Calculated Lease Rate for CarId : yVL1LDMonWOurPK : 50.75
        
  
  
  Note : There are many usecases and area of improvements which can be implemented in future implementatitons like 
  1. Assign Car to Customer on Lease for certain period - for that Mapping(parent-child) of Car and Customer table can be done or New Assignment table can be created for maintaing Car Lease Information.
  2. Validations and implementation of logging framework.
  
  
  
      
