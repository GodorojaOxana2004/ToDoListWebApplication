package project.example.dao;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.example.entity.Record;
import project.example.entity.RecordStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class RecordDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public List<Record> findAllRecords () {
        Query query = entityManager.createQuery("SELECT r FROM Record r order by id ASC ");
        List<Record> records = query.getResultList();
        return records;
    }

    @Transactional
    public void saveRecord (Record record) {
        entityManager.persist(record);
    }

    @Transactional
    public void updateRecordStatus (int id, RecordStatus newStatus) {
        Query query = entityManager.createQuery("UPDATE Record SET status = :status WHERE id = :id");
        query.setParameter("id", id);
        query.setParameter("status", newStatus);
        query.executeUpdate();
    }

    @Transactional
    public void deleteRecord (int id) {
        Query query = entityManager.createQuery("DELETE FROM Record WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
