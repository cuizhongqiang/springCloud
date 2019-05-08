# springCloud
  微服务架构版本说明：
     spring cloud : Greenwich.RELEASE
     spring boot : 2.1.3.RELEASE
+ demo-eureka-server 服务注册中心
+ demo-eureka-config-server 配置服务（RabbitMQ整合 -- spring cloud netflix bus消息总栈）实现Web服务与配置信息的存放位置解耦
+ demo-eureka-gateway 路由网关，异步io，zuul-多线程阻塞
+ demo-eureka-client,demo-eureka-clientb 集群客户端服务，服务消费（依赖配置服务）
+ demo-eureka-ribbon-server 客户端的负载均衡
+ demo-eureka-feign-server 调用远端服务的REST接口
+ demo-eureka-turbine 断路器Hystrix Dashboard监控，Turbine多流监控
