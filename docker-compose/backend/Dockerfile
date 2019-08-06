FROM node:8.11.2
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app/
ADD .* /usr/src/app/
ADD ./* /usr/src/app/
COPY package.json /usr/src/app
RUN npm install
COPY . /usr/src/app
EXPOSE 5000
CMD ["npm","start"]