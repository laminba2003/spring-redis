# Spring Redis

Performance is one of the most important metrics we need to evaluate when developing a web service/Application. Keeping customers engaged is critical to any product and for this reason, it is extremely important to improve the performances and reduce page load times.

When running a web server that interacts with a database, its operations may become a bottleneck. MongoDB is no exception here, and as our MongoDB database scales up, things can really slow down. This issue can even get worse if the database server is detached from the web server. In such systems, the communication with the database can cause a big overhead.

In this example, we’ll introduce this method and see how we can use it to enhance the performance of our application using Spring Cache, Spring Data, and Redis.

## Start the Services

run this command to start all services in the correct order.

```bash
$ docker-compose up -d
```

## Connect to the mongodb container

```bash
$ docker exec -it mongodb bash
```

### Connect to a specific database with mongodb shell

```bash
$ mongosh "mongodb://localhost:27017/spring"  --username root --password password  --authenticationDatabase admin
```

### Verify current connection

```bash
$ db.getMongo()
```

### Query collections

```bash
$ db.getCollectionNames()
```

### Create documents

```bash
$ db.users.insert({"firstName" : "John",
                   "lastName" : "Doe",
                   "userName": "john",
                   "password": "password"})
```

### Query documents

```bash
$ db.users.find()
```

## Connect to the redis container

```bash
$ docker exec -it redis sh
```

### Connect to redis with the cli

```bash
$ redis-cli
```

### Query keys

```bash
$ KEYS *
```


### Monitor commands

```bash
$ MONITOR
```