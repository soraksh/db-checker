# DB Checker 
Simple application able to check PostgreSQL database connections with simple REST API

# Db connection info entity
Db connection info entity json:
```
{
  "id": UUID|Null
  "name": String
  "hostname": String
  "port": Integer
  "databaseName": String
  "username": String
  "password": String|Null
}
```

# Endpoints

## Db connection info entity endpoints

- Get list of all db connection info entities.
```
#GET /dbconnection
```

- Get singe db connection info entitiy by name. Returns `EntityNotFoundException` if entity not found.
```
#GET /dbconnection/{name}
```

- Save new db connection info entity.
```
#POST /dbconnection
Content-Type: application/json
```

- Update existing db connection info entity by name or create new if entity with that name does not exist.
```
#PUT /dbconnection/{name}
Content-Type: application/json
```

- Delete existing db connection info entity by name
```
#DELETE /dbconnection
Content-Type: application/json
```

## Database metadata endpoints

- Get list of all schemas from database found by given `name` of db connection info entity.
```
#GET /dbmetadata/schemas/{name}
```

- Get list of all tables from database found by given `name` of db connection info entity.
```
#GET /dbmetadata/tables/{name}
```

- Get list of all columns from table with name `tableName` from database found by given `name` of db connection info entity.
```
#GET /dbmetadata/columns/{name}/{tableName}
```

- Get list of first 50 rows as data preview of table with name `tableName` from database found by given `name` of db connection info entity.
```
#GET /dbmetadata/preview/{name}/{tableName}
```

