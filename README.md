## 本项目实现的最终作用是基于SSH实现的KTV管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 分类管理
 - 商品管理
 - 管理员和用户管理
 - 管理员登陆
 - 订单管理
 - 评价管理
### 第2个角色为用户角色，实现了如下功能：
 - 个人信息查看
 - 发表评价
 - 提交订单
 - 查看包间
 - 查看我的预定
 - 查看购物车
 - 用户登录
 - 用户首页
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_ktv_sys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_admin](#t_admin) |  |
| [t_book](#t_book) |  |
| [t_category](#t_category) |  |
| [t_category_sec](#t_category_sec) |  |
| [t_comment](#t_comment) |  |
| [t_order](#t_order) |  |
| [t_orderitem](#t_orderitem) |  |
| [t_product](#t_product) |  |
| [t_user](#t_user) | 用户表 |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | adminname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 管理员名称  |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  6   | sex |   int   | 10 |   0    |    N     |  N   |       | 性别  |

**表名：** <a id="t_book">t_book</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | bookTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  5   | product_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 商品ID  |
|  6   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  7   | uid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_category">t_category</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | cname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 分类名称  |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |

**表名：** <a id="t_category_sec">t_category_sec</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | scname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | category_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |

**表名：** <a id="t_comment">t_comment</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | reply |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 回复  |
|  6   | replyTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  7   | product_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 商品ID  |
|  8   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_order">t_order</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | orderTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  4   | status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  5   | total |   double   | 23 |   0    |    N     |  N   |       | 总计  |
|  6   | uid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  7   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_orderitem">t_orderitem</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | count |   int   | 10 |   0    |    N     |  N   |       | 数量  |
|  3   | subtotal |   double   | 23 |   0    |    Y     |  N   |   NULL    | 金额  |
|  4   | order_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 订单ID  |
|  5   | product_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 商品ID  |

**表名：** <a id="t_product">t_product</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | image |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图片  |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  5   | price |   double   | 23 |   0    |    N     |  N   |       | 价格  |
|  6   | remark |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |
|  7   | categorySec_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | category_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 地址  |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | password |   varchar   | 255 |   0    |    N     |  N   |       | 密码  |
|  5   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  6   | sex |   int   | 10 |   0    |    Y     |  N   |   NULL    | 性别  |
|  7   | username |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  8   | loginName |   varchar   | 255 |   0    |    N     |  N   |       |   |

