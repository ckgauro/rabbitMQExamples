package com.gauro.rabbitmqexceptiondlxconsumer.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chandra
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    private String name;
    private String type;
    private String source;
    private long size;
}