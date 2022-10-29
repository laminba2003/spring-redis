# Spring Redis

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