package project.example.dao;

import org.springframework.stereotype.Repository;
import project.example.entity.Record;
import project.example.entity.RecordStatus;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecordDao {
    private final List<Record> records = new ArrayList<>(
            List.of(
                    new Record("Take a shower", RecordStatus.ACTIVE),
                    new Record("Go to the Gym", RecordStatus.DONE),
                    new Record("Buy flowers", RecordStatus.ACTIVE)
    ));

    public List<Record> findAllRecords(){
        return new ArrayList<>(records);
    }

    public void saveRecord(Record record){
        records.add(record);
    }

    public void updateRecordStatus(int id, RecordStatus recordStatus){
        for (Record item: records){
            if(item.getId() == id){
                item.setRecordStatus(recordStatus);
                break;
            }
        }
    }

    public void DeleteRecord(int id) {
        records.removeIf(item -> item.getId() == id);
    }
}
