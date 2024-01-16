FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENV MONGODB_URI=mongodb+srv://d-programming:Debmallya182001@genzapp.cmnudmw.mongodb.net/Genzapp
EXPOSE 8080