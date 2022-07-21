start nacos
docker run -d -p 8848:8848 --env MODE=standalone  --name nacos  zhusaidong/nacos-server-m1:2.0.3
docker run --rm -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.8-management

curl -X POST http://localhost:8080/orders -H "Content-Type: application/json" -d '{"productGuid": "1", "quantity": 1,"amount":99.99}'

docker run -d --name jaeger \
-p 6831:6831/udp \
-p 6832:6832/udp \
-p 5778:5778 \
-p 16686:16686 \
-p 4317:4317 \
-p 4318:4318 \
-p 14250:14250 \
-p 14268:14268 \
-p 14269:14269 \
-p 9411:9411 \
jaegertracing/all-in-one

java -Dotel.traces.exporter=jaeger \
-Dotel.exporter.jaeger.endpoint=http://localhost:14250 \
-Dotel.metrics.exporter=none \
-Dotel.resource.attributes="service.name=order" \
-Dotel.javaagent.debug=false \
-javaagent:opentelemetry-javaagent.jar \
-jar bookstore/order/build/libs/order-boot.jar

java -Dotel.traces.exporter=jaeger \
-Dotel.exporter.jaeger.endpoint=http://localhost:14250 \
-Dotel.metrics.exporter=none \
-Dotel.resource.attributes="service.name=productpage" \
-Dotel.javaagent.debug=false \
-javaagent:opentelemetry-javaagent.jar \
-jar bookstore/productpage/build/libs/productpage.jar

java -Dotel.traces.exporter=jaeger \
-Dotel.exporter.jaeger.endpoint=http://localhost:14250 \
-Dotel.metrics.exporter=none \
-Dotel.resource.attributes="service.name=delivery" \
-Dotel.javaagent.debug=false \
-javaagent:opentelemetry-javaagent.jar \
-jar bookstore/delivery/build/libs/delivery.jar
