# 武平工业大脑平台

基于 [JeecgBoot 3.9.3](https://github.com/jeecgboot/JeecgBoot) AI 低代码平台构建的工业产业大脑管理系统。

## 项目结构

```
├── JeecgBoot-main/                    # 主项目
│   ├── jeecg-boot/                    # 后端 Java 源码 (Spring Boot 4)
│   │   ├── jeecg-boot-base-core/      # 核心框架（权限、ORM、工具类、AOP）
│   │   ├── jeecg-module-system/       # 系统管理（用户/角色/菜单/字典/租户）
│   │   ├── jeecg-boot-module/
│   │   │   ├── jeecg-module-demo/     # 业务模块
│   │   │   │   ├── land_parcel/       # 地块管理
│   │   │   │   ├── company_info/      # 企业信息管理
│   │   │   │   ├── investment_project/# 招商项目管理
│   │   │   │   ├── standard_workshop/ # 标准车间管理
│   │   │   │   └── device/            # 设备管理
│   │   │   └── jeecg-boot-module-airag/ # AI 应用（知识库/流程编排/聊天助手）
│   │   ├── jeecg-server-cloud/        # 微服务模块（Nacos/Gateway/Sentinel）
│   │   ├── db/                        # 数据库初始化脚本 (MySQL 5.7+)
│   │   └── docs/                      # 项目文档
│   └── jeecgboot-vue3/                # 前端 Vue3 源码
│       ├── src/views/demo/            # 业务管理页面
│       │   ├── land_parcel/           # 地块管理
│       │   ├── company_info/          # 企业信息管理
│       │   ├── investment_project/    # 招商项目管理
│       │   ├── standard_workshop/     # 车间管理
│       │   └── device/                # 设备管理
│       └── src/views/dashboard/       # 数据大屏
│           ├── Overview.vue           # 概览大屏
│           ├── Enterprise.vue         # 企业大屏
│           ├── Project.vue            # 项目大屏
│           ├── LandParcel.vue         # 地块大屏
│           ├── Device.vue             # 设备大屏
│           └── Workshop.vue           # 车间大屏
├── README.md                          # 本文件
└── .gitignore                         # Git 忽略配置
```

## 技术栈

| 层级 | 技术 |
|------|------|
| 后端框架 | Spring Boot 4.1.0 + MyBatis-Plus 3.5.16 |
| 安全认证 | Apache Shiro 3.0.0 + JWT 4.5.0 |
| 微服务 | Spring Cloud Alibaba (Nacos/Gateway/Sentinel) |
| 前端 | Vue3 + TypeScript + Vite6 + Ant Design Vue4 |
| 报表大屏 | JimuReport 积木报表 + JimuBI 大屏 |
| 工作流 | Flowable BPM |
| AI 能力 | ChatGPT / DeepSeek / Ollama / 千问 / 智谱 |
| 数据库 | MySQL 8.0+（兼容达梦/PostgreSQL/Oracle/SQL Server） |
| 缓存 | Redis |
| 文件存储 | MinIO / 阿里云 OSS / 本地存储 |
| 在线文档 | WPS WebOffice |

## 环境要求

- **JDK** 17+（支持 21、24）
- **Maven** 3.6+
- **Node** 20+ / **pnpm** 9+
- **MySQL** 8.0+ / **Redis**

运行环境检查脚本：
```bash
python check_jeecgenv.py
```

## 快速启动

### 后端
```bash
cd JeecgBoot-main/jeecg-boot

# 初始化数据库（导入 db/jeecgboot-mysql-5.7.sql）

# 编译
mvn clean install -DskipTests

# 启动（单体模式）
mvn spring-boot:run -pl jeecg-module-system/jeecg-system-start
```
访问: http://localhost:8080/jeecg-boot/doc.html

### 前端
```bash
cd JeecgBoot-main/jeecgboot-vue3

# 安装依赖
pnpm install

# 启动开发服务器
pnpm dev
```
访问: http://localhost:3100

### Docker 一键启动
```bash
cd JeecgBoot-main
docker-compose up -d
```

### 微服务模式
```bash
# 启动 Nacos
cd JeecgBoot-main
docker-compose -f docker-compose-cloud.yml up -d

# IDE 中依次启动各服务
```

## 默认账号

| 账号 | 密码 | 角色 |
|------|------|------|
| admin | 123456 | 超级管理员 |

## 功能模块

### 业务管理
- **招商项目管理** — 项目全生命周期管理（项目编号/名称/产业类型/投资额/建设进度/关联企业）
- **地块管理** — 工业地块信息维护（地块名称/面积/状态/所属园区）
- **企业信息管理** — 入驻企业信息管理（企业名称/信用代码/联系人/行业分类）
- **车间管理** — 标准车间信息维护
- **设备管理** — 生产设备台账管理

### 数据可视化
- 概览大屏、企业大屏、项目大屏、地块大屏、设备大屏、车间大屏

### AI 应用
- AI 聊天助手（支持文字/图片/文件）
- AI 知识库问答（RAG 检索增强生成）
- AI 流程编排
- AI 模型管理
- MCP 插件

### 平台能力
- 在线表单设计（零代码快速搭建）
- 代码生成器（一键生成前后端代码 + SQL）
- 报表与大屏设计器（拖拽式）
- 流程设计器（BPM 工作流）
- RBAC 权限控制（按钮级 + 数据级）
- SaaS 多租户

## 代码生成后修复

生成完代码后运行修复脚本（修正路径和注解格式）：
```bash
fix-after-gen.bat
```

## 文档

- [JeecgBoot 开发文档](https://help.jeecg.com)
- [AI 应用手册](https://help.jeecg.com/aigc)
- [SpringCloud 微服务](https://help.jeecg.com/java/springcloud/switchcloud/monomer)

## License

[Apache License 2.0](LICENSE)
