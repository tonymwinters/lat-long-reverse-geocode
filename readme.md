Latitude / Longitude Reverse Geocoder
==========

There are 2 ways to build/run this Spring Boot app. 
In both cases, an environment variable needs to be set. That is the `GOOGLE_API_KEY`. 


From the root directory of the project, run one of the following:

1. Regular Jar

`mvn clean package`

`java -jar target/lat-long-1.jar {KEY_GOES_HERE}`

2. Docker

`mvn clean package`

`docker build -t latlong .`

`docker run -p 8080:8080 -e "GOOGLE_API_KEY={KEY_GOES_HERE}" latlong`

3. Make HTTP Requests to the following endpoints

    - (GET) `http://localhost:8080/api/getAddress?latitude={latitude_goes_here}&longitude={longitude_goes_here}`
    - (GET) `http://localhost:8080/api/getCache`
    
    `/getAddress` takes in a `latitude` and `longitude` URL parameter
    
    `/getCache` doesn't take in any parameters