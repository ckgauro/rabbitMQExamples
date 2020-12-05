package com.gauro.rabbitmq.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gauro.rabbitmq.json.CustomLocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Chandra
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @JsonProperty("employee_id")
    private String employeeId;

    private String name;

    @JsonProperty("birth_date")
    @JsonDeserialize(using= CustomLocalDateDeserializer.class)
    private LocalDate birthDate;
}
