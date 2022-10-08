
docker-build:
	docker build -t eshurupov/evanli-wallets:1.2 -t eshurupov/evanli-wallets:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/evanli-wallets

docker-build-push: docker-build docker-push
