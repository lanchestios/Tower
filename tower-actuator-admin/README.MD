# Actuator 相关介绍
## 常用端点
使用 /actuator 端点可以获取应用启用的所有端点列表
1. autoconfig (敏感信息)

    查看自动配置的使用情况，显示一个auto-configuration的报告，该报告展示所有auto-configuration候选者及其情况

2. conditions
   
    获取自动配置条件信息。访问 /actuator/conditions 接口获取SpringBoot自动配置的条件信息，这些信息反映了SpringBoot在实现自动配置过程中的条件信息
   
3. configprops

    查看SpringBoot应用的所有配置属性，包括默认配置，显示一个所有 @configuration-Properties 的整理列表
    
4. beans

   获取bean及其关系列表，显示一个应用中所有SpringBeans的完整列表。访问 /actuator/beans 可以获取当前SpringBoot应用Spring容器中所有的Bean信息及其依赖关系

5. env

    查看所有环境变量
    
    访问 /actuator/env 可以获取到几乎你能想到的所有关于当前SpringBoot应用程序的运行环境信息，例如：操作系统信息(systemProperties)、环境变量信息、JDK版本及ClassPath信息、当前启用的配置文件(activeProfiles)、propertySources、应用程序配置信息(applicationConfig)等。

6. env/{name}

    查看具体变量值
    
7. health

    查看应用健康指标

8. info

    查看应用信息
    
9. loggers

    获取系统日志信息
    
10. mappings

    查看所有URL映射。即所有＠RequestMapping路径的整理列表。
   
11. metrics

    获取系统度量指标信息
    
12. metrics/{name}

    获取系统度量指标信息时，查看具体指标
    
13. scheduledtasks

    获取系统定时任务信息
    
14. shutdown

    关闭应用，允许应用以优雅的方式关闭(默认情况下不启用)
    
15. threaddump

    获取系统线程转储信息
    
16. trace

    查看基本追踪信息，默认为最新的一些HTTP请求

