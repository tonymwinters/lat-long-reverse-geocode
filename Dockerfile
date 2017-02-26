FROM frolvlad/alpine-oraclejdk8:slim
ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
CMD java -jar -DGOOGLE_API_KEY=$GOOGLE_API_KEY /app.jar