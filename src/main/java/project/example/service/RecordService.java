package project.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.dao.RecordDao;
import project.example.entity.Record;
import project.example.entity.RecordStatus;

import java.util.List;

@Service
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService (RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public List<Record> findAllRecord () {
        return recordDao.findAllRecords();
    }

    public void saveRecord (String taskDescription) {
        if (taskDescription != null && !taskDescription.isBlank()) {
            recordDao.saveRecord(new Record(taskDescription));
        }

    }

    public void updateRecordStatus(int id, RecordStatus recordStatus){
        recordDao.updateRecordStatus(id,recordStatus);
    }

    public void DeleteRecord(int id) {
        recordDao.DeleteRecord(id);
    }
}
