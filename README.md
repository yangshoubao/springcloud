# springcloud
生成jks文件命令:
keytool -genkeypair -alias fzp-jwt -validity 365 -keyalg RSA -dname "CN=jwt,OU=jtw,O=jtw,L=zurich,S=zurich,C=CN" -keypass fzp123 -keystore fzp-jwt.jks -storepass fzp123
-alias选项为别名, -keypass和-storepass为密码选项, -validity为jks文件的过期时间(单位:天)
获取jks文件公钥命令:
密码为fzp123
keytool -list -rfc --keystore fzp-jwt.jks | openssl x509 -inform pem -pubkey
新建public.cert文件, 将公钥信息复制到public.cert文件中保存.
