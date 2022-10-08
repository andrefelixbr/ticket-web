# Ticket-web

## Execute testes

 `mvn test`
 

## Q&A

 Acesse a pasta docker/qa e execute o comando `docker-compose up` para iniciar o SonarQube.



Você pode precisar configurar o seu sistema operacional para utilizar o ElasticSearch que vem embarcado no 
SonarQube

```
  sudo sysctl -w vm.max_map_count=262144
```

## Run sonarQube

`mvn clean verify sonar:sonar -Dsonar.login=${SONAR_TOKEN}`