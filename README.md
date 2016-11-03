[![Build Status](https://travis-ci.org/ExampleDriven/spring-boot-heroku-example.svg?branch=master)](https://travis-ci.org/ExampleDriven/spring-boot-heroku-example)

## Prerequisites

``` shell
heroku login
#This step is only required if the applications are not yet created
heroku create <<WEB SERVICE NAME>> --no-remote
heroku create <<WORKER SERVICE NAME>> --no-remote

heroku config:set WORKER_HOST=<<WORKER SERVICE NAME>>.herokuapp.com
```


## Deploy using heroku CLI
``` shell
heroku plugins:install heroku-cli-deploy
mvn clean install
cd web-service
heroku deploy:jar target/web-service-0.0.1-SNAPSHOT.jar --app <<WEB SERVICE NAME>>
cd ../worker-service
heroku deploy:jar target/worker-service-0.0.1-SNAPSHOT.jar --app <<WORKER SERVICE NAME>>
```

## Deploy using maven without installing heroku CLI
The application name is written into the pom.xml, it should be updated to match the application names created above
``` shell
cd web-service
HEROKU_API_KEY="xxx-xxx-xxxx" mvn heroku:deploy
cd ../worker-service
HEROKU_API_KEY="xxx-xxx-xxxx" mvn heroku:deploy
```

## Deploy using maven with installing heroku CLI
``` shell
cd web-service
mvn heroku:deploy
cd ../worker-service
mvn heroku:deploy
```

## Checking logs
``` shell
heroku logs --tail --app <<WEB SERVICE NAME>>
heroku logs --tail --app <<WORKER SERVICE NAME>>
```


## Resources:
- https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin
- https://devcenter.heroku.com/articles/deploying-executable-jar-files