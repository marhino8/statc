package com.amdprofile.statcollector;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    public Record saveRecord(Record record){
       return recordRepository.save(record);
    }


    public List<Record> getAllRecords() {
        return recordRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTime"));
    }
}
