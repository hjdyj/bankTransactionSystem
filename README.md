# 银行交易管理系统 (Banking Transaction Service)


## 📌 项目简介
本项目是基于 **Java 17 + Spring Boot 3 + H2 内存数据库** 的轻量级银行交易管理系统。项目支持交易的 **增删改查（CRUD）** 操作，遵循 RESTful API 设计原则，并支持分页查询。


---


## 🚀 快速启动


### 1. 克隆代码
```bash
git clone <your-repo-url>
cd banking-system
```


### 2. 运行项目
使用 Maven 命令：
```bash
mvn spring-boot:run
```
或者在 IDE（如 IntelliJ IDEA）中直接运行 `BankingApplication` 类。


### 3. 访问服务
- API 根路径: [http://localhost:8080/transactions](http://localhost:8080/transactions)
- H2 数据库控制台: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:bankdb`
- User: `sa`
- Password: *(空)*


---


## 📖 API 文档


### 1. 创建交易
**POST** `/transactions`
```json
{
"type": "deposit",
"amount": 500.00,
"description": "Salary deposit"
}
```
返回示例：
```json
{
"id": 1,
"type": "deposit",
"amount": 500.00,
"description": "Salary deposit",
"createdAt": "2025-09-24T17:30:00"
}
```


### 2. 查询交易（分页）
**GET** `/transactions?page=0&size=5`
返回示例：
```json
{
"content": [
{
"id": 1,
"type": "deposit",
"amount": 500.00,
"description": "Salary deposit",
"createdAt": "2025-09-24T17:30:00"
}
---
