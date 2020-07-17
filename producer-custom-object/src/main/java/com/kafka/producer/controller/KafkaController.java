package com.kafka.producer.controller;

import com.kafka.producer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    KafkaTemplate<String, Employee> customKafkaTemplate;

    private static final String TOPIC = "employee";
    private Long idCounter =0L;

    @GetMapping("/employee/{name}")
    public String postMessage(@PathVariable("name") String name){
        idCounter++;
        customKafkaTemplate.send(TOPIC,new Employee(idCounter,name));
        return "Employee with name "+name+" published successfully";
    }

}
