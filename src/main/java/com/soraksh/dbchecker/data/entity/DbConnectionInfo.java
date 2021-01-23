package com.soraksh.dbchecker.data.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "DB_CONNECTION_INFO")
public class DbConnectionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "HOSTNAME", nullable = false)
    private String hostname;

    @Column(name = "PORT", nullable = false)
    private int port;

    @Column(name = "DATABASE_NAME", nullable = false)
    private String databaseName;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
