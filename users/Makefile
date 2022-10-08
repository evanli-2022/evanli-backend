
docker-build:
	docker build -t eshurupov/evanli-users:1.1 -t eshurupov/evanli-users:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/evanli-users

docker-build-push: docker-build docker-push
