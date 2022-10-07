FROM nginx:1.17.1-alpine
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
ADD default.conf /etc/nginx/conf.d/
EXPOSE 80