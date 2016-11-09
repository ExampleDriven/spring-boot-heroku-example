[![Build Status](https://travis-ci.org/ExampleDriven/spring-boot-heroku-example.svg?branch=master)](https://travis-ci.org/ExampleDriven/spring-boot-heroku-example)

This is the source code for the blog post

https://exampledriven.wordpress.com/2016/11/04/spring-boot-heroku-example/

## Deploy using git
``` shell
#Download an empty spring boot application
curl https://start.spring.io/starter.tgz -d style=web -d style=actuator -d name=heroku-example | tar -xzvf -

git init
git add .
git commit -m "initial commit"

heroku create
git push heroku master
```

## Prerequisites for deploying without git

``` shell
heroku login
#This step is only required if the applications are not yet created
heroku create <WEB SERVICE NAME> --no-remote
heroku create <WORKER SERVICE NAME> --no-remote

heroku config:set WORKER_HOST=<WORKER SERVICE NAME>.herokuapp.com
```


## Deploy using heroku CLI deploy
``` shell
heroku plugins:install heroku-cli-deploy
mvn clean install
cd web-service
heroku deploy:jar target/web-service-0.0.1-SNAPSHOT.jar --app <WEB SERVICE NAME>
cd ../worker-service
heroku deploy:jar target/worker-service-0.0.1-SNAPSHOT.jar --app <WORKER SERVICE NAME>
```

## Deploy using maven without installing heroku CLI
The application name is written into the pom.xml, it should be updated to match the application names created above
In this example the heroku plugin is moved to a build profile called heroku that can be activated using
``` shell
mvn clean install -Pheroku
```

The non profile version would work like this

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
heroku logs --tail --app <WEB SERVICE NAME>
heroku logs --tail --app <WORKER SERVICE NAME>
```


## Resources:
- https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin
- https://devcenter.heroku.com/articles/deploying-executable-jar-files
