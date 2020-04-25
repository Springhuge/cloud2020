Eureka保护机制：

保护模式主要用于一组客户端和Eureka Server之间存在网络分区场景下的保护。一旦进行保护模式，Eureka Server将会尝试保护其服务注册表中的信息，不再删除服务注册表中的数据，也就是不会注销任何微服务。



如果在Eureka Server的首页看到以下提示，则说明Eureka进来保护模式。

EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.