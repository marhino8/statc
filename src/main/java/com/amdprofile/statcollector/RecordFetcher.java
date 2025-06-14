package com.amdprofile.statcollector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RecordFetcher {

    private final RestTemplate restTemplate;

    @Autowired
    public RecordFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Scheduled(fixedDelayString = "#{T(java.util.concurrent.ThreadLocalRandom).current().nextInt(420000, 600001)}")
    public void fetchRecords() {
        String url = "https://statc.onrender.com/record/getAll";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        } catch (Exception e) {
            log.error("ERROR MAKE REQUEST: {}", e.getMessage());
        }
    }
}