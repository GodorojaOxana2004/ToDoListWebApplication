package project.example.entity;

public class Record {
    private static int countId = 0;
    private final int id;
    private String title;
    private RecordStatus recordStatus;


    public String getTitle () {
        return title;
    }

    public int getId () {
        return id;
    }

    public Record (String title) {
        this.id=countId++;
        this.title = title;
        this.recordStatus = RecordStatus.ACTIVE;
    }
    public Record (String title, RecordStatus recordStatus) {
        this.id=countId++;
        this.title = title;
        this.recordStatus = recordStatus;
    }



    public RecordStatus getRecordStatus () {
        return recordStatus;
    }

    public void setRecordStatus (RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

}
