# 项目说明
## 本项目关于简单的自定义工作流实现一套简单框架
## 本项目使用在Spring环境中

# 使用说明
## 引入项目jar包

## resources目录配置json文件
- 定义stage-action对应关系

## 自定义ProcessConfigCacheImpl
- 获取所有json文件及stage-action对应关系

## 自定义Router（可忽略）
- 定义stage跳转逻辑

## 根据json文件定义若干action
- 实现框架BusinessAction接口，定义各自实现类
- 将Action实现成bean（ProcessExecutorImpl通过application.getBean(beanName)调用

## 引入ProcessExecutor和DefaultRouter bean
- 框架中ProcessExecutor和DefaultRouter bean已经通过XML形式配置成Spring bean，故在代码中可以直接autowire

## 定义ProcessContext
- 传入business，product code，用于寻找json文件
- 传入DataEntity，用于封装action所需数据
- 根据ProcessConfigCacheImpl 将ProcessConfig塞到ProcessContext中

## 使用ProcessExecutor执行ProcessContext开启job调度

# 使用方式参照test ProcessConfigCacheImplTest