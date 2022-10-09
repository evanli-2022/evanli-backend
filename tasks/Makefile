
docker-build:
	docker build -t eshurupov/evanli-tasks:1.0 -t eshurupov/evanli-tasks:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/evanli-tasks

docker-build-push: docker-build docker-push
