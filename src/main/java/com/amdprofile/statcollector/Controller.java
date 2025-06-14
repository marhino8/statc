package com.amdprofile.statcollector;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
