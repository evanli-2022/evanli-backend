
docker-build:
	docker build -t eshurupov/evanli-balancer:1.3 -t eshurupov/evanli-balancer:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/evanli-balancer

docker-build-push: docker-build docker-push
