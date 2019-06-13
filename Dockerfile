FROM ubuntu:latest

WORKDIR /app

COPY . /app

RUN apt-get update -qqy && apt-get install -y wget \
    gnupg2 && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list' && \
    apt update && apt install -y google-chrome-stable \
    xvfb \
    default-jdk \
    maven

ENTRYPOINT (Xvfb :0 -screen 0 1920x1080x24 &) && \
           export DISPLAY=:0 && \
           mvn test -Dtest=Runner

