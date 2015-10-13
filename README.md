# CustomersMailCloud - Java/SES
Amazon SESのインターフェースで、SMTPサーバにメールを送信するJavaライブラリです。 
AWS SDK for Java が提供するAmazonSimpleEmailServiceClient クラスの代わり使用することができます。

## Requirement
JDK1.6以上  
AWS SDK for Java 1.10.22  
CustomersMailCloud java-smtp-client 1.0.0  

## Build
ご自身でソースからビルドする場合、以下の手順でビルドしてください。  
```
$ git clone https://github.com/hde-cm/java-ses-client.git
$ cd java-ses-client
$ mvn install
$ cp target/cmc-ses-1.0.0.jar ./cmc-ses.jar
```

## Install
cmc-smtp.jar を <https://github.com/hde-cm/java-smtp-client> からダウンロードしてください。  
cmc-smtp.jar と cmc-ses.jar をクラスパスが通っているディレクトリにコピーしてください。  

## Usage
使用方法は、<https://smtps.jp/doc/javases.html> を参照してください。

## License
本ソースコードは、Apache License Version 2.0 で提供します。

## Author
Masahiro Okubo HDE, Inc.
