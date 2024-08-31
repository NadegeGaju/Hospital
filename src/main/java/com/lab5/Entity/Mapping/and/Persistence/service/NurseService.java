package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.NurseModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public NurseModel saveNurse(NurseModel nurse) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            NurseModel savedNurse = nurseRepository.save(nurse);
            transactionManager.commit(status);
            return savedNurse;
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    public NurseModel getNurse(Long id) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            Optional<NurseModel> nurse = nurseRepository.findById(id);
            transactionManager.commit(status);
            return nurse.orElse(null);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    public void deleteNurse(Long id) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            nurseRepository.deleteById(id);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
