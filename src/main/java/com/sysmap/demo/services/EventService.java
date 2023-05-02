package com.sysmap.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService{
    @Autowired
    private KafkaAutoConfiguration
}
