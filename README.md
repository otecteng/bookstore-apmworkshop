start nacos
docker run -d -p 8848:8848 --env MODE=standalone  --name nacos  zhusaidong/nacos-server-m1:2.0.3
docker run --rm -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.8-management

curl -X POST http://localhost:8080/orders -H "Content-Type: application/json" -d '{"productGuid": "1", "quantity": 1,"amount":99.99}'


