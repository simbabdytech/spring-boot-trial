# spring-boot-trial

样例程序

```shell
curl -X GET -H "Content-Type: application/json" "http://127.0.0.1:8762/hello"
```

```shell
curl -X POST -H "Content-Type: application/json" "http://127.0.0.1:8762/hi?name=testUser"
```

```shell
curl -X POST -H "Content-Type: application/json" "http://127.0.0.1:8762/hi"
```

```shell
curl -X GET -H "Content-Type: application/json" -H "X-Timezone: Europe/London" "http://127.0.0.1:8762/get-time"
```

```shell
curl -X POST -H "Content-Type: application/json" -H "X-Timezone: Europe/London" "http://127.0.0.1:8762/post-time"
```
