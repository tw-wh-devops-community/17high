# 17High

[![Build Status](https://travis-ci.org/tw-wh-devops-community/17high.svg?branch=master)](https://travis-ci.org/tw-wh-devops-community/17high)

## Requirement:

[Docker](https://docs.docker.com/docker-for-mac/install/#download-docker-for-mac) is installed;

## Run Spring boot on local
```
gradle bootRun
#或
./gradlew bootRun
```
You need not start mysql on local manually. bootRun will start a loacl mysql Docker automaticly.

## Run Mysql on local Docker
you can run
```
./startMysql.sh
```
to start a local Dcoker with Mysql 5.7 ( This step is already integrated to gradle bootRun)

## Run Sonarqube on local

### Requirement:
A Docker Deamon is running, you can use docker-machine create a local VM to host Docker server like:
```
docker-machine create --driver virtualbox default.
```
```
eval $(docker-machine env default)
```

### Start Sonarqube on local
```
cd Sonarqube
docker-compose up
```
### Check the VM IP
```
docker-machine env default
#或
docker-machine ssh default 'ifconfig eth1 | grep "inet addr:" | cut -d: -f2 | cut -d" " -f1'
```

### Run Sonar by gradle
```
gradle sonarqube
```
then open http://VM-IP:9000 to view sonarqube
