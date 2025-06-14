package com.amdprofile.statcollector;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class Controller {


    private final RecordService recordService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveRecord(@RequestBody Record record) {
        log.info("save endpoint called with request body: {}", record);
        recordService.saveRecord(record);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Record>> getAllRecords() {
        log.info("getAll endpoint called");
        return ResponseEntity.ok().body(recordService.getAllRecords());
    }

}
