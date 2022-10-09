# Backend Part of EvAnLi team solution for [MoreTech Hackathon](https://moretech.vtb.ru/) in 2022

## Team members:
* [Evgeny](https://www.linkedin.com/in/evgeny-shurupov/)
* [Anton](https://github.com/uskov-anton)
* [Lisa](https://www.behance.net/lisasavelieva)

## Backend part consists of 
* [Users Microservice](/users)
* [Wallets Microservice](/wallets)
* [Tasks Microservice](/tasks)

## Starting microservices in docker-compose
* Production version. To start execute `docker-compose up`  
  
* Development version. To start execute `docker-compose --file docker-compose-dev.yml up`

  Before starting all services have to be built to jar-files.

## Starting microservices in kubernetes
Go to [k8s](/k8s) folder and apply all configs here. 

Now it's deployed [here](http://146.185.243.90/swagger-ui/index.html) in k8s. 