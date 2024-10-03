# sorveteria-quarkus-api

# Downloads

1. Download and install Java JDK https://www.oracle.com/br/java/technologies/downloads/
2. Download and install Maven https://maven.apache.org/download.cgi
3. Download and install PostgreSQL https://www.postgresql.org/download
4. (optional) Download and install IntelliJ Community (free) https://www.jetbrains.com/pt-br/idea/download/other.html

# Step by step for the creation of this repo

1. Run the following command on windows CMD
   
   ```shell
   mvn io.quarkus.platform:quarkus-maven-plugin:3.15.1:create -DprojectGroupId=io.github.felipedemacedo -DprojectArtifactId=sorveteria-quarkus-api
   ```
   
    * If using Powershell, wrap -D parameters in double quotes e.g. "-DprojectArtifactId=my-artifactId"
      
3. Install dependencies
   - hibernate-validator
   - jdbc-h2
   - hibernate-orm
   - hibernate-orm-panache
   - resteasy-jsonb

   with the following command on CMD:
   ```shell
   ./mvnw quarkus:add-extension -Dextensions="hibernate-validator,jdbc-h2,hibernate-orm,hibernate-orm-panache,resteasy-jsonb"
   ```

   Alternatively you can add these lines into pom.xml:
   ```xml 
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-validator</artifactId>
   </dependency>
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-jdbc-h2</artifactId>
   </dependency>
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-orm</artifactId>
   </dependency>
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-orm-panache</artifactId>
   </dependency>
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-jsonb</artifactId>
   </dependency>
   ```
   
4. Install Prometheus for metrics adding these lines into pom.xml:
   
   ```xml 
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-smallrye-metrics</artifactId>
   </dependency>
   ```
   
     ![image](https://github.com/user-attachments/assets/e419cd50-094d-4748-8bb7-1493ee08dd3f)
     
6. Run the following command on windows CMD
   
   ```shell
   ./mvnw compile quarkus:dev
   ```
   
   The result should be something like this:
   ![image](https://github.com/user-attachments/assets/8aff052b-7ace-4c95-8d06-5317adf6732a)
   
   More info here: Using Quarkus with Maven https://quarkus.io/guides/maven-tooling
   
7. Test project with Postman:
   | Test Case 1 | Test Case 2 | Test Case 3 |
   | - | - | - |
   | ![image](https://github.com/user-attachments/assets/af627e57-112b-4632-a392-47f4c5f90071) | ![image](https://github.com/user-attachments/assets/5cae12af-397b-4011-b32b-9a88c262705d) | ![image](https://github.com/user-attachments/assets/8d90d76f-adf2-47ab-bbd2-deb6687db069) |


   

   

   

   

