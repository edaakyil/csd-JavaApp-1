
# 006-DemoNetworkInfoService


### Uygulamayı normal profilden çalıştırma (uygulamayı direkt çalıştırma):

- console komutları:
```cmd
~\006-DemoNetworkInfoService> mvn clean package
~\006-DemoNetworkInfoService> cd .\target\
~\006-DemoNetworkInfoService> java -jar .\NetworkInfoService-1.0.0.jar 
```


### Uygulamayı **_dev_** profilinden çalıştırma:

- dev profili oluşturma:
> ~\006-DemoNetworkInfoService\src\main\resources\\**application-dev.properties**
> ```properties
> spring.application.name=NetworkInfoService
> 
> server.port=6767
> 
> ```

- console komutları:
```cmd
~\006-DemoNetworkInfoService> mvn clean package
~\006-DemoNetworkInfoService> cd .\target\
~\006-DemoNetworkInfoService> java -jar .\NetworkInfoService-1.0.0.jar --spring.profiles.active=dev   
```


### Uygulamayı dilediğimiz bir server port'dan çalıştırma:

- console komutları:
```cmd
~\006-DemoNetworkInfoService> mvn clean package
~\006-DemoNetworkInfoService> cd .\target\
~\006-DemoNetworkInfoService> java -jar .\NetworkInfoService-1.0.0.jar --server.port=4567  
```



```java
```

```java
```