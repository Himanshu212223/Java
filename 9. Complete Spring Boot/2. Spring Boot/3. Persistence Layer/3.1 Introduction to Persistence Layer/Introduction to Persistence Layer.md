# Persistence Layer

- Persistence Layer interacts with Service layer and the Database.

- It's work is to get data from Service Layer and perform operations on database.

## Different approaches to use Persistence Layer

Spring provides below approaches to interacts with Database-

1. Spring ORM

2. Spring Data

3. Spring JDBC

-----------------------------------------------------------

### How to Install MySQL ..?

We can download the mysql server locally using link - https://dev.mysql.com/downloads/installer/

Now, find the MySQL server downloaded file from `C:\Program Files\MySQL\MySQL Server 8.0\bin` etc, copy the file location and store it on System Environment Variables path.

Now, to run the mysql server, open cmd and use the below command-

```
mysql -u root -p
```

If you want to run the mysql server on different port, open cmd and use below command-

```
mysql -u root -p --port=8624
```