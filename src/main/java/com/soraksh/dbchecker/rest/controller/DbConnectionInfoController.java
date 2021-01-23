package com.soraksh.dbchecker.rest.controller;

import com.soraksh.dbchecker.data.entity.DbConnectionInfo;
import com.soraksh.dbchecker.service.ConnectionControllerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DbConnectionInfoController {

    @Autowired
    protected ConnectionControllerManager manager;

    @GetMapping("/dbconnection")
    protected Iterable<DbConnectionInfo> findAll() {
        return manager.findAll();
    }

    @PostMapping("/dbconnection")
    protected DbConnectionInfo create(@RequestBody DbConnectionInfo connectionInfo) {
        return manager.create(connectionInfo);
    }

    @GetMapping("/dbconnection/{name}")
    protected DbConnectionInfo findOne(@PathVariable String name) {
        return manager.findOne(name);
    }

    @PutMapping("/dbconnection/{name}")
    protected DbConnectionInfo updateOne(@PathVariable String name,
                                         @RequestBody DbConnectionInfo connectionInfo) {
        return manager.updateOne(name, connectionInfo);
    }

    @DeleteMapping("/dbconnection/{name}")
    protected void delete(@PathVariable String name) {
        manager.delete(name);
    }
}
