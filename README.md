# jwt-spring-boot
JWT integration with Spring Boot as 'Bearer Token'.

It Helps to integrate any implementation of JWT with Spring Boot as Security Provider

Clases in impl package are Vendor and Client Specific. Current implementation gives an idea to achieve the same.

# How To:
  First Generate the token from JWTTokenTest class under test package.
  Start ApplicationMain class, it will start application with tmcat running at '8080' port and 'jwt' as applicaton deploy point.
  Use any Rest Client like Postman, Set Authorization header to 'Bearer *****'. (Generated in First Step)
  Hit http://localhost:8080/jwt/user/get
  
# NOTE:
  Current implementation generates token with 5 minutes expiry. 
