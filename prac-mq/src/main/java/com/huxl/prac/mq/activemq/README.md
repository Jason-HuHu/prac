# active mq 安装
## 步骤
1. 查询Docker 镜像
```bash
docker search activemq
```
2. 下载Docker 镜像
```bash
docker pull webcenter/activemq
```
3. 创建和运行ActiveMQ容器
```bash
docker run -d --name myactivemq -p 61616:61616 -p 8161:8161 webcenter/activemq
```
4. 查看WEB管理页面

浏览器输入：http://192.168.99.100:8161/ 点击Manager ActiveMQ Broker 使用默认账号admin/admin进入查看
# active mq 的入门使用

参考：https://www.cnblogs.com/jaycekon/p/6225058.html