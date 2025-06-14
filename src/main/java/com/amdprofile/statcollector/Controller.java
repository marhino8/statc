package com.amdprofile.statcollector;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class Controller {


    private final RecordService recordService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveRecord(@RequestBody Record record) {
        recordService.saveRecord(record);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Record>> getAllRecords() {
        return ResponseEntity.ok().body(recordService.getAllRecords());
    }

}
