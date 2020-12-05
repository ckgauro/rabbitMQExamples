package com.gauro.rabbitmqproducer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gauro.rabbitmqproducer.json.CustomLocalDateSerializer;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Chandra
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @JsonProperty("employee_id")
    private String employeeId;

    private String name;

    @JsonProperty("birth_date")
    @JsonSerialize(using= CustomLocalDateSerializer.class)
    private LocalDate birthDate;
}
