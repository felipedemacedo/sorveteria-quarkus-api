# sorveteria-quarkus-api

# Downloads

1. Download and install Java JDK https://www.oracle.com/br/java/technologies/downloads/
2. Download and install Maven https://maven.apache.org/download.cgi

# Step by step for the creation of this repo



1. Run the following command on windows CMD
   ```shell
   mvn io.quarkus.platform:quarkus-maven-plugin:3.15.1:create -DprojectGroupId=io.github.felipedemacedo -DprojectArtifactId=sorveteria-quarkus-api
   ```
    * If using Powershell, wrap -D parameters in double quotes e.g. "-DprojectArtifactId=my-artifactId"
  
2. Run the following command on windows CMD
   ```shell
   ./mvnw compile quarkus:dev
   ```
3. The result should be something like this:
   ![image](https://github.com/user-attachments/assets/8aff052b-7ace-4c95-8d06-5317adf6732a)

More info here: Using Quarkus with Maven https://quarkus.io/guides/maven-tooling
