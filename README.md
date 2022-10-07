# Backend Part of EvAnLi team solution for [MoreTech Hackathon](https://moretech.vtb.ru/) in 2022

## Team members:
* [Evgeny](https://www.linkedin.com/in/evgeny-shurupov/)
* [Anton](https://github.com/uskov-anton)
* [Lisa](https://www.behance.net/lisasavelieva)

## Backend part consists of 
* [Users Microservice](/users)
* [Transactions Microservice](/transactions)
* [Marketplace Microservice](/market)

## Starting microservices in docker-compose
* Production version. To start execute `docker-compose up`
  
  Before starting all services have to be built to docker image and pushed to docker hub.
  
  
* Development version. To start execute `docker-compose --file docker-compose-dev.yml up`

  Before starting all services have to be built to jar-files.

## Starting microservices in kubernetes
Go to [k8s/configs](k8s/configs) folder and apply all configs here