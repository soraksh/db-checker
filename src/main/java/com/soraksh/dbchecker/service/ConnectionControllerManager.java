package com.soraksh.dbchecker.service;

import com.soraksh.dbchecker.data.entity.DbConnectionInfo;
import com.soraksh.dbchecker.data.repository.DbConnectionInfoRepository;
import com.soraksh.dbchecker.rest.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@Component(ConnectionControllerManager.NAME)
public class ConnectionControllerManager {
    public static final String NAME = "ConnectionControllerManager";

    @Autowired
    protected DbConnectionInfoRepository repository;

    public Iterable<DbConnectionInfo> findAll() {
        return repository.findAll();
    }

    public DbConnectionInfo create(DbConnectionInfo connectionInfo) {
        return repository.save(connectionInfo);
    }

    public DbConnectionInfo findOne(String name) {
        return repository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException("Database connection info", name));
    }

    public DbConnectionInfo updateOne(String name, DbConnectionInfo connectionInfo) {
        DbConnectionInfo foundConnectionInfo = repository.findByName(name).orElse(new DbConnectionInfo());
        foundConnectionInfo.setName(connectionInfo.getName());
        foundConnectionInfo.setDatabaseName(connectionInfo.getDatabaseName());
        foundConnectionInfo.setHostname(connectionInfo.getHostname());
        foundConnectionInfo.setUsername(connectionInfo.getUsername());
        foundConnectionInfo.setPassword(connectionInfo.getPassword());
        foundConnectionInfo.setPort(connectionInfo.getPort());
        foundConnectionInfo = repository.save(foundConnectionInfo);
        return foundConnectionInfo;
    }

    @Transactional
    public void delete(@PathVariable String name) {
        repository.deleteByName(name);
    }
}
