# 差异

1. 修正书中配置遗漏的permitAll函数调用。
2. 由于5.x版本之后默认启用了委派密码编码器，按照以往的方式设置内存密码将会读取异常，所以暂时需要将密码编码器设置为NoOpPasswordEncoder。
3. SQL连接地址增加了serverTimezone=GMT配.置以适应新版本驱动。
4. 建表语句单引号改反引号。
5. Mapper扫描路径根据实际情况调整。
6. 增加successHandler。
7. 修正书中遗漏的csrf关闭动作。