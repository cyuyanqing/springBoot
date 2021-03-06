底层架构

    以 Spring Boot 2 为基础，Maven 多项目依赖，模块分项目，松耦合，方便模块升级、增减模块。
    模块化的数据库自动升级程序，当模块升级代码需要更新数据库时，自动执行对应版本 SQL 脚本。
    权限授权模块灵活，支持 CAS 单点登录，简单 yml 配置即可，不用再写很多的 xml 配置文件。
    支持多数据源，分布式事务，简单 yml 配置即可实现，为了安全性，不提供界面维护数据源。
    数据表主键优化，如分类科目表，采用有意义的主键方式，让客户去自定义，减少后期运维维护成本。

    实体 @Table 注解配置：
        自动生成增删改 SQL，不需要在 mapper.xml 里写重复又费时的 SQL 了，减少开发和后期维护成本。
        所有列 @Column 定义均放到类头，而不是分布到各个属性或方法上，非常好，主要是有如下原因：
        一是，放到表头的好处是，可一览熟知该实体类对应的物理表结构是什么样，开发者思维从物理表结构到对象的映射转换，都是基于物理表结构的，@Column 指定物理字段名，而不是指定类上的属性名，也是这个原因；
        二是，生成的 SQL 和查询条件，可定义列的排列顺序，方便核查定义，优化查询，提升性能；
        三是，方便 @JoinTable 关联表和其它扩展信息的设置，如果分布到类的属性上就不太好管理列。
    用户数据权限优化，不仅仅是角色，颗粒度细化到每个人员的身上，可自定义第三方数据权限，不仅仅是部门和公司，你可以扩展，如：地区，栏目分类，商品分类。
    缓存监控，J2Cache 二级缓存，支持快速切换为 Redis 缓存，集群 Session 缓存共享。
    服务器监控，查看 CPU，内存，JVM，磁盘信息等。方便运维人员分析系统负载情况。
    支持 SAAS 多租户模式，每个租户数据通过 corp_code 字段进行分离，数据互不干扰。
    支持 Spring Cloud 架构，分布式，微服务，最小化内核，统一配置中心，统一授权认证中心。
    树结构的图特设计，提高运维、数据分析、优化查询。
    多用户类型支持：员工、会员、往来的单位等。

2、安全方面

    原有 JeeSite 1.2 安全选项及安全考虑保留。
    支持数据库密码及其它安全密钥自动加密配置。
    所有请求参数获取，均通过 XSS 跨站脚本过滤方法。
    乐观锁简单实现，必要情况下使用，提高数据安全性。
    通过 yml 简单配置，轻松解决 JS 是否允许跨域操作。

    身份认证：
        登录失败多少次后显示验证码。
        登录失败多少次后锁定账号及锁定账号时间。
        登录账号密码可加密后再提交后台。
        同设备是否允许账号多地登录。

    密码策略：
        初始密码修改策略，提醒或强制用户修改初始密码。
        账号密码修改策略，多长时间内未修改，则提醒或强制修改密码。
        账号密码安全等级限制策略，很弱密码，弱密码，安全密码，很安全密码

    权限审计：
        菜单权限都有哪些用户拥有查询。
        哪些用户拥有哪些菜单查询。
        敏感菜单设置及提醒设置。

3、用户界面

    基于 Bootstrap 3 平面化界面设计，精细，更加美观、高端、大气、上档次。
    支持手机或平板访问，响应式样式、响应式布局，根据屏幕分辨率自适应控件布局。
    无刷新设计，除了进入功能页面和新页面，其它情况下全部采用 Ajax 交互，优化体验和性能。
    支持一键换肤，只需在 yml 里修改下主题名称即可快速切换整个UI的风格，不仅仅是色调和样式，布局也可改变。支持自定义扩展项目独有的主题样式风格。
    优化用户功能操作，大众思维模式，功能清晰，更加贴切和友好。
    国际化的支持，页面标签国际化，字典菜单国际化，数据国际化。

4、前端开发

    采用当前比较流行的 Beetl 模板引擎，它的优点很多，大家可自行查阅看看，这里不多说了。
    封装 Beetl UI 通用组件，简单实现基本表单控件、树选择，列表选择，文件上传，等等，总之是简化开发。
    数据表格 jqGrid 组件封装，自动完成分页、排序、列宽、多表头、子表、编辑表、等。
    支持前后分离应用，方便与手机 API 接口对接，Token 方式授权。

5、功能及组件

    工具类 Utils 封装优化，应有尽有，包分类层次分明，独立工具类项目。
    强大的 Excel 导出导入工具封装，支持大数据量，注解定义，简单配置即可实现。
    在线任务调度，界面化管理，可新增，编辑、删除、暂停、恢复、运行一次等操作，支持独立数据源，分布式作业调度，调度日志监控分析查询。
    代码生成工具操作简化及优化，支持多数据源。
    在线查询在线人员，强踢在线账号。
