# Eudon Parent 项目

## 项目简介

Eudon Parent 是一个基于 Spring Boot 3.2.0 的企业级微服务项目模板，采用模块化设计，提供了完整的开发框架和通用组件。项目遵循分层架构设计，具有良好的可扩展性和维护性。

## 项目架构

```
eudon-parent/
├── eudon-commons/          # 通用组件模块
│   ├── eudon-common-core/      # 核心工具类
│   ├── eudon-common-boot/      # Spring Boot 配置
│   ├── eudon-common-json/      # JSON 处理组件
│   ├── eudon-common-datasource/ # 数据源配置
│   ├── eudon-common-framework/  # 框架配置
│   ├── eudon-common-log/        # 日志组件
│   ├── eudon-common-doc/        # API 文档配置
│   ├── eudon-common-starter/    # 自动配置启动器
│   └── eudon-common-zookeeper/  # Zookeeper集成
└── eudon-service/          # 业务服务模块
    ├── controller/         # 控制器层
    ├── service/           # 服务层
    ├── manager/           # 管理层
    ├── dao/              # 数据访问层
    ├── domain/           # 领域模型
    └── utils/            # 工具类
```

## 技术栈

### 核心框架
- **Spring Boot**: 3.2.0
- **Spring Framework**: 基于 Spring Boot 3.2.0
- **MyBatis Plus**: 3.5.5

### 数据库与缓存
- **MySQL**: 8.0.31
- **Redis**: 3.2.0
- **Redisson**: 3.17.7
- **Druid**: 1.2.14 (数据库连接池)

### 中间件
- **RabbitMQ**: Spring Boot AMQP 3.2.0
- **Elasticsearch**: 7.12.1
- **Sharding-JDBC**: 5.5.1 (分库分表)
- **Zookeeper**: 3.8.0 (分布式协调服务)

### 工具库
- **Hutool**: 5.8.24 (Java 工具类库)
- **FastJSON**: 2.0.16 (JSON 处理)
- **Apache Commons**: 
  - Commons IO: 2.6
  - Commons Lang3: 3.12.0
  - Commons Collections4: 4.4
  - Commons Codec: 1.13

### 开发工具
- **Lombok**: 1.18.24
- **SpringDoc OpenAPI**: 2.5.0 (API 文档)
- **JUnit**: 3.8.1 (单元测试)
- **Mockito**: 5.12.0 (Mock 测试)

## 模块说明

### eudon-commons (通用组件模块)

#### eudon-common-core
核心工具类模块，包含：
- **枚举管理**: `BaseEnum` 接口和 `Gender` 等枚举实现
- **异常处理**: `BusinessException`、`SystemException` 等异常类
- **缓存工具**: `LRUCache` 等缓存实现
- **工具类**: `EnumUtil`、`RegisterBeanUtil` 等通用工具

#### eudon-common-json
JSON 处理组件，包含：
- **序列化器**: `BaseEnumSerializer`、`BigDecimalSerializer`、`SensitiveSerializer`
- **反序列化器**: `BaseEnumDeserializer`、`DateDeserializer`
- **敏感数据处理**: `@Sensitive` 注解和 `SensitiveUtil` 工具类

#### eudon-common-datasource
数据源配置模块，支持：
- 多数据源配置
- 分库分表（ShardingSphere-JDBC，shardingsphere-jdbc主依赖，适配Spring Boot 3.x）
- 数据库连接池管理

#### eudon-common-doc
API 文档配置模块：
- 基于 SpringDoc OpenAPI 3.0
- 自动生成 Swagger 文档
- 支持多环境配置

#### eudon-common-framework
框架配置模块：
- Spring Boot 自动配置
- 框架级配置管理

#### eudon-common-log
日志组件模块：
- 统一日志配置
- 日志格式化管理

#### eudon-common-starter
自动配置启动器：
- 统一依赖管理
- 自动配置加载

#### eudon-common-zookeeper
Zookeeper集成模块，包含：
- **分布式锁**: `ZkLock` 接口和 `DefaultZkLockImpl` 实现
- **监控指标**: `ZookeeperMetrics` 监控类
- **配置管理**: 支持Zookeeper配置中心集成

### eudon-service (业务服务模块)

#### 分层架构
- **Controller 层**: REST API 接口定义
- **Service 层**: 业务逻辑处理
- **Manager 层**: 复杂业务编排
- **DAO 层**: 数据访问接口
- **Domain 层**: 领域模型定义

#### 示例功能
- 用户管理 (`TbUserEntity`)
- 测试接口 (`TestController`)
- 完整的 CRUD 操作示例

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+

### 安装步骤

1. **克隆项目**
```bash
git clone https://github.com/EudonSong/eudon-parent.git
cd eudon-parent
```

2. **配置数据库**
编辑 `eudon-service/src/main/resources/application-dev.yml`，配置数据库连接信息。

3. **编译项目**
```bash
mvn clean compile
```

4. **运行项目**
```bash
cd eudon-service
mvn spring-boot:run
```

5. **访问应用**
- 应用地址: http://localhost:8080/dev
- API 文档: http://localhost:8080/dev/swagger-ui.html
- 测试接口: http://localhost:8080/dev/test

### 配置说明

#### 多环境配置
项目支持多环境配置：
- `application-dev.yml`: 开发环境
- `application-test.yml`: 测试环境
- `application-prod.yml`: 生产环境

通过 `spring.profiles.active` 参数指定运行环境。

#### 数据库配置
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/eudon_db
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

#### Redis 配置
```yaml
spring:
  redis:
    host: localhost
    port: 6379
    password: your_password
    database: 0
```

## 开发规范

### 代码规范
- 遵循阿里巴巴 Java 开发手册
- 使用 Lombok 简化代码
- 统一异常处理机制
- 完善的日志记录

### 包结构规范
```
com.eudon.service
├── controller/     # 控制器层
├── service/       # 服务层
├── manager/       # 管理层
├── dao/          # 数据访问层
├── domain/       # 领域模型
│   ├── entity/   # 实体类
│   ├── dto/      # 数据传输对象
│   ├── req/      # 请求对象
│   └── resp/     # 响应对象
└── utils/        # 工具类
```

### 异常处理
- 业务异常使用 `BusinessException`
- 系统异常使用 `SystemException`
- 统一异常拦截处理

### 枚举使用
所有枚举类实现 `BaseEnum` 接口：
```java
public enum Gender implements BaseEnum {
    MALE("1", "男", "男性"),
    FEMALE("0", "女", "女性");
    
    private final String code;
    private final String value;
    private final String desc;
}
```

## 特性功能

### 1. 统一异常处理
- 全局异常拦截
- 统一错误码管理
- 友好的错误信息返回

### 2. 数据脱敏
- 支持字段级数据脱敏
- 自定义脱敏规则
- 自动序列化处理

### 3. 缓存支持
- Redis 缓存集成
- 本地缓存支持
- 缓存策略配置

### 4. 分库分表
- Sharding-JDBC 集成
- 支持水平分片
- 灵活的分片策略
- ShardingSphere-JDBC 集成（shardingsphere-jdbc主依赖，适配Spring Boot 3.x）
- 支持水平分片
- 灵活的分片策略

### 5. 消息队列
- RabbitMQ 集成
- 消息持久化
- 死信队列处理

### 7. 分布式锁
- Zookeeper 分布式锁实现
- 支持可重入锁
- 锁监控指标

### 6. 搜索引擎
- Elasticsearch 集成
- 全文搜索支持
- 复杂查询优化

## 测试

### 单元测试
```bash
mvn test
```

### 集成测试
项目包含完整的测试示例，位于 `eudon-service/src/test/` 目录下。

## 部署

### Docker 部署
```bash
# 构建镜像
mvn clean package docker:build

# 运行容器
docker run -p 8080:8080 eudon-service:latest
```

### 传统部署
```bash
# 打包
mvn clean package

# 运行
java -jar eudon-service/target/eudon-service-1.0-SNAPSHOT.jar
```

## 贡献指南

1. Fork 项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 联系方式

- 作者: eudon
- 邮箱: syd19970616@gmail.com
- GitHub: [https://github.com/EudonSong](https://github.com/EudonSong)
- Gitee: [https://gitee.com/eudon](https://gitee.com/eudon)

## 更新日志

### v1.0-SNAPSHOT
- 初始版本发布
- 基础框架搭建
- 核心功能实现
- 示例代码完善
- 分库分表依赖升级为shardingsphere-jdbc，适配Spring Boot 3.x
