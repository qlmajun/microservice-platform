# microservice-platform

## 启动参数配置

Run/Debug Configurations   ->   Program arguments

```
--NACOS_HOST=192.168.133.163:8765 --NACOS_NAMESPACE=nledu-iotbd --NACOS_GROUP=dev
```

## 开发规范

### 命名约定

#### 文件命名

- 微服务工程以Server结尾。
- Service接口以I开头，实现类去掉I。例：IUserService、UserService
- DAO以Mapper结尾。
- 页面传输对象以DTO结尾。

#### 方法命名

- 获取单个对象的方法用get做前缀
- 获取多个对象的方法用list做前缀
- 获取统计值的方法用count做前缀
- 插入的方法，service用save、dao用insert做前缀
- 修改的方法，用update做前缀
- 删除的方法，service用remove、dao用delete做前缀

### 前后端REST接口规范

#### 接口开发原则

- 增删改查遵循 REST 规范
- 前端对响应数据的判断先基于http状态码，再分析对应的json数据。

| Http状态码 | 说明                 |
| ---------- | -------------------- |
| 200        | 正常响应             |
| 401        | 未登录               |
| 403        | 无权限               |
| 500        | 系统错误、业务错误等 |


参考：

https://www.cnblogs.com/kkdn/p/9124526.html

## 代码提交规范
- feat：新功能（feature）

- fix：修补bug

- docs：文档（documentation）

- style： 格式（不影响代码运行的变动）

- refactor：重构（即不是新增功能，也不是修改bug的代码变动）

- test：增加测试

- chore：构建过程或辅助工具的变动