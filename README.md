
Java 本地方法调用实现调用 `getpid` 对比，[JNI](https://en.wikipedia.org/wiki/Java_Native_Interface) vs. [JNA](https://github.com/java-native-access/jna) vs. [JNR](https://github.com/jnr/jnr-ffi)

JNI 示例编译与运行（Mac 环境）：

```
$ mkdir -p target/classes
$ javac src/main/java/com/test/GetPidJni.java -d "target/classes"
$ javah -cp "target/classes" com.test.GetPidJni
$ gcc -I $JAVA_HOME/include -I $JAVA_HOME/include/darwin -dynamiclib -o libgetpidjni.dylib com_test_GetPidJni.c
$ java -Djava.library.path=`pwd` -cp "target/classes" com.test.GetPidJni
```


JNA 示例编译与运行：

```
$ mvn install
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJna
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJna
```


JNR 示例编译与运行：

```
$ mvn install
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJnr
```

参见资料：

2013-07 Charles Nutter: Java Native Runtime <http://www.oracle.com/technetwork/java/jvmls2013nutter-2013526.pdf>
