# jwt-spring-boot
JWT integration with Spring Boot as 'Bearer Token'.

It Helps to integrate any implementation of JWT with Spring Boot as Security Provider.

# How To:
	1. First Generate the token from JWTTokenTest class under test package.
	2. Start ApplicationMain class, it will start application with tmcat running at '8080' port and 'jwt' as applicaton deploy point.
	3. Use any Rest Client like Postman, Set Authorization header to 'Bearer *****'. (Generated in First Step)
	4. Hit http://localhost:8080/jwt/user/get
  
# NOTE:
	- Current implementation generates token with 5 minutes expiry.
	- Clases in impl package are Vendor/Client Specific. Current implementation gives an idea to achieve the same. 
