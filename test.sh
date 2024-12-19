#!/usr/bin/env bash

CurrentDir=$(dirname $0)

echo ""
curl -X GET -H "Content-Type: application/json" "http://127.0.0.1:8762/hello"

echo ""
curl -X POST -H "Content-Type: application/json" "http://127.0.0.1:8762/hi?name=testUser"

echo ""
curl -X POST -H "Content-Type: application/json" "http://127.0.0.1:8762/hi"

echo ""
curl -X GET -H "Content-Type: application/json" -H "X-Timezone: Europe/London" "http://127.0.0.1:8762/get-time"

echo ""
curl -X POST -H "Content-Type: application/json" -H "X-Timezone: Europe/London" "http://127.0.0.1:8762/post-time"

echo ""
