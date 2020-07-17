# Kafka-Custom-Producer
It publishes custom objects to kafka consumer

Follow the below steps to run this program and see how the kafka consumer receives the message sent by the producer we created programmatically.

1. Download Apache Kafka from https://kafka.apache.org/downloads

2. Extract it and copy the content to a preferred location.e.g. C:\Users{USER_NAME}\Documents\Kafka

3. Create a directory named "data" under the "Kafka" folder and then create two folders named "zookeeper" and "kafka" under the "data" folder.

4. Open zookeper.properties under "config" folder and update the property "dataDir"which should point to your newly created zookeper folder in step 3.
 
  e.g. dataDir=C:/Users/{USER_NAME}/Documents/Kafka/data/zookeeper

5. Open server.properties under "config" folder and update the property "log.dirs"which should point to your newly created kafka folder in step 3.
   
   e.g. log.dirs=C:/Users/{USER_NAME}/Documents/Kafka/data/kafka

6. Now we are all set in terms of configuration. Please make sure your JAVA_HOME is set properly in your system, else you will not be able to start and run kafka.

7. Now open a command prompt at the location mentioned in Step 2 and run the below command to start zookeper (I am using Windows machine) 

  bin\windows\zookeeper-server-start.bat config\zookeeper.properties

8. Now open another command prompt at the location mentioned in Step 2 and run the below command to start kafka server(I am using Windows machine) 

  bin\windows\kafka-server-start.bat config\server.properties

9. Now open another command prompt at the location mentioned in Step 2 and run the below command to start kafka consumer(I am using Windows machine) 

  bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic employee --from-beginning

10. Here I am trying to read the messages from the topic "employee" as our kafka producer is publishing messages to the same topic. Initially it will be blank.

11. Now publish employee objects by starting the above spring boot application and hitting the below URL in your browser http://localhost:8082/kafka/employee/{EMPLOYEE_NAME}

12. Now you can check the consumer console which will display the same employee object published by your producer.
