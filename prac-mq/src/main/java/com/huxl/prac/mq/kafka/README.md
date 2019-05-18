# kafka 安装
## 步骤
1. 搜索docker镜像

```bash
docker search zookeeper
docker search kafka
```

2. 下载docker 镜像

```bash
docker pull wurstmeister/zookeeper
docker pull wurstmeister/kafka
docker pull sheepkiller/kafka-manager
```

3. 创建和运行zk 和kafka容器

```bash
# 启动zk
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
# 启动kafka
docker run -d --name kafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=192.168.99.100 --env KAFKA_ADVERTISED_PORT=9092 --volume /etc/localtime:/etc/localtime wurstmeister/kafka:latest
#启动kafka管理工具
docker run -it -d --rm  -p 9000:9000 -e ZK_HOSTS="192.168.99.100:2181" --net=host sheepkiller/kafka-manager
```
4. 验证kafka安装情况
1.进入到kafka容器中 并创建topic 生产者，执行如下命令：

```bash

docker exec -it kafka bash
cd /opt/kafka_2.11-2.0.0/bin/
./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 8 --topic test
./kafka-console-producer.sh --broker-list localhost:9092 --topic test

#　ctrl+d 可以直接退出容器

```

2.执行上述命令后，创建kafka消费者消费消息

```bash
docker exec -it kafka bash
cd /opt/kafka_2.11-2.0.0/bin/
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```
3.在生产者窗口输入任意内容后回车，可以在消费者窗口查看到对应内容

4. 在kafka集群管理页面 http://192.168.99.100:9000 新建待管理的集群，可以查看到上面创建的主题 test
# kafka使用

