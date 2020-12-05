package com.gauro.rabbitmqfanoutexchangeconsumer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gauro.rabbitmqfanoutexchangeconsumer.json.CustomLocalDateDeserializer;
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
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate birthDate;
}
