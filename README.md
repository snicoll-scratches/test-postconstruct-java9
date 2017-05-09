This project demonstrates that `@PostConstruct` does not seem to be called at all when
the application is running with Java 9. It works fine with Java 8.

To reproduce:

`$ mvn -version` should yield

```
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T21:39:06+02:00)
Maven home: /Users/snicoll/tools/maven
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.4", arch: "x86_64", family: "mac"
```

Invoke `$ mvn clean spring-boot:run` and look for
`=========== PostConstruct called =========` and `Hello Embedded World!`

This is the expected behaviour. Now switch to Java9:

```
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T21:39:06+02:00)
Maven home: /Users/snicoll/tools/maven
Java version: 9-ea, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk-9.jdk/Contents/Home
Default locale: en_BE, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.4", arch: "x86_64", family: "mac"
```

Run the same command (`$ mvn clean spring-boot:run`) and you should only get
`Hello Embedded Jar!` (the post construct hasn't been called).