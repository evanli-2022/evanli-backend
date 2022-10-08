
docker-build:
	docker build -t eshurupov/evanli-market:1.0 -t eshurupov/evanli-market:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/evanli-market

docker-build-push: docker-build docker-push
