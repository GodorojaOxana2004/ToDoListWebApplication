package project.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.dao.RecordDao;
import project.example.entity.Record;
import project.example.entity.RecordStatus;
import project.example.entity.dto.RecordsContainerDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService (RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public RecordsContainerDto findAllRecord(String filterMode) {

       List<Record> records = recordDao.findAllRecords();
       int numberDoneRecords = (int) records.stream().filter(record -> record.getRecordStatus() == RecordStatus.DONE).count();
        int numberActiveRecords = (int) records.stream().filter(record -> record.getRecordStatus() == RecordStatus.ACTIVE).count();
       if (filterMode == null || filterMode.isBlank()){
           return new RecordsContainerDto(records,numberDoneRecords,numberActiveRecords);
       }

       String inUpperModeFilter = filterMode.toUpperCase();
        List<String> allowedFilterMode = Arrays.stream(RecordStatus.values()).map(Enum::name).toList();
       if(allowedFilterMode.contains(inUpperModeFilter)){
        List<Record> filteredRecords =  records.stream().filter(record -> record.getRecordStatus() == RecordStatus.valueOf(inUpperModeFilter)).toList();
       return new RecordsContainerDto(filteredRecords,numberDoneRecords,numberActiveRecords);
       }
        return new RecordsContainerDto(records,numberDoneRecords,numberActiveRecords);

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
