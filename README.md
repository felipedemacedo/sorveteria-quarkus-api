# sorveteria-quarkus-api

# Downloads

1. Download and install Java JDK https://www.oracle.com/br/java/technologies/downloads/
2. Download and install Maven https://maven.apache.org/download.cgi
3. Download and install PostgreSQL https://www.postgresql.org/download
4. (optional) Download and install IntelliJ Community (free) https://www.jetbrains.com/pt-br/idea/download/other.html

# Step by step for the creation of this repo

## 1. Run the following command on windows CMD
   
   ```shell
   mvn io.quarkus.platform:quarkus-maven-plugin:3.15.1:create -DprojectGroupId=io.github.felipedemacedo -DprojectArtifactId=sorveteria-quarkus-api
   ```

If using Powershell, wrap -D parameters in double quotes e.g. "-DprojectArtifactId=my-artifactId"
      
## 2. Install dependencies

   ```
      - hibernate-validator
      - jdbc-h2
      - hibernate-orm
      - hibernate-orm-panache
      - resteasy-jsonb
   ```

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
   
## 3. Install Prometheus for metrics adding these lines into pom.xml:
   
   ```xml 
   <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-smallrye-metrics</artifactId>
   </dependency>
   ```
   
   ![image](https://github.com/user-attachments/assets/e419cd50-094d-4748-8bb7-1493ee08dd3f)
     
## 4. Run the following command on windows CMD
   
   ```shell
   ./mvnw compile quarkus:dev
   ```
   
   The result should be something like this:
   ![image](https://github.com/user-attachments/assets/8aff052b-7ace-4c95-8d06-5317adf6732a)
   
   More info here: Using Quarkus with Maven https://quarkus.io/guides/maven-tooling
   
## 5. Test project with Postman:
   | Test Case 1 | Test Case 2 | Test Case 3 |
   | - | - | - |
   | ![image](https://github.com/user-attachments/assets/af627e57-112b-4632-a392-47f4c5f90071) | ![image](https://github.com/user-attachments/assets/5cae12af-397b-4011-b32b-9a88c262705d) | ![image](https://github.com/user-attachments/assets/8d90d76f-adf2-47ab-bbd2-deb6687db069) |

## 6. Validate Prometheus is functional
   ### 6.1. You may download and install it from: https://prometheus.io/download/
   ### 6.2. Modify prometheus.yml pointing it into the endpoint we created (localhost:8080/q/metrics):
   
   ```shell
   scrape_configs:
     - job_name: "prometheus"
       metrics_path: '/q/metrics'
       static_configs:
         - targets: ["localhost:8080"]
   ```

   ### 6.3. Run prometheus.exe (Windows) and validate api metrics are present. 
   
   ![image](https://github.com/user-attachments/assets/8048c19e-cbd3-4373-805f-7289af016572)
   
   <img width="637" alt="image" src="https://github.com/user-attachments/assets/2bdc8552-4a94-4967-9475-d57ba662fc36">

## 7. (optional) Install and use Grafana
   ### 7.1. Download it from https://grafana.com/
   ### 7.2. Run Grafana Server

   ![image](https://github.com/user-attachments/assets/1dc3c514-dd61-4ad3-b97e-4cf0a6299caa)

   ### 7.3. Configure it for reading Prometheus as data source

   ![image](https://github.com/user-attachments/assets/5147a119-3bd2-4da4-9127-2eab1084278b)

## 8. (optional) Scale it up with Kubernetes
   ### 8.1. Download kubectl 
   
   https://kubernetes.io/releases/download/#binaries
   
   ### 8.2. Download minikube
   
   https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download
   
   ### 8.3. Download Virtualbox or use Hyper-V
   
   https://www.virtualbox.org/
   
   ### 8.4. Start minikube

   ```shell
   minikube start
   ```

   In case of error, run:
   ```shell
   minikube delete
   minikube start
   ```

   Verify status with:
   ```shell
   minikube status
   ```
   ![image](https://github.com/user-attachments/assets/fed7465a-3635-4fa9-a39f-9f4658406494)

   ### 8.5. (optional) Install VSCode extensions 

   ![image](https://github.com/user-attachments/assets/47cba049-1dd8-4441-9bbc-bd80d62f677c)

   ![image](https://github.com/user-attachments/assets/f0a630c9-33d0-47d9-ac6c-f3457dae5489)


   

   

   

   

