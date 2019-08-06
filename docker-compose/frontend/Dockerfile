FROM node:8.11.2
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app/
ADD .* /usr/src/app/
ADD ./* /usr/src/app/
RUN npm install -g ember-cli
COPY package.json /usr/src/app
RUN npm install
COPY . /usr/src/app
EXPOSE 4200
CMD ["npm","start"]