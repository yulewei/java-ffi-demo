
Java 本地方法调用实现调用 `getpid` 对比，[JNI](https://en.wikipedia.org/wiki/Java_Native_Interface) vs. [JNA](https://github.com/java-native-access/jna) vs. [JNR](https://github.com/jnr/jnr-ffi)

JNI 示例编译与运行（Mac 环境）：

```
$ mkdir -p target/classes
$ javac src/main/java/com/test/GetPidJni.java -d "target/classes"
$ javah -cp "target/classes" com.test.GetPidJni
$ gcc -I $JAVA_HOME/include -I $JAVA_HOME/include/darwin -dynamiclib -o libgetpidjni.dylib com_test_GetPidJni.c
$ java -Djava.library.path=`pwd` -cp "target/classes" com.test.GetPidJni
```


JNA 示例编译与运行（包括 [Interface Mapping](https://github.com/java-native-access/jna/blob/master/www/FunctionalDescription.md#interface-mapping) 和 [Direct Mapping](https://github.com/java-native-access/jna/blob/master/www/FunctionalDescription.md#direct-mapping) 两种方式）：

```
$ mvn install
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJna
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJnaDirect
```


JNR 示例编译与运行：

```
$ mvn install
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJnr
```

JMH 性能测试代码：

```
$ mvn install
$ java -cp "target/java-ffi-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.BenchmarkFFI
```

JMH 性能测试结果：

```
# JMH version: 1.19
# VM version: JDK 1.8.0_144, VM 25.144-b01
Benchmark                          Mode  Cnt      Score      Error   Units
BenchmarkFFI.testGetPidJna        thrpt   10   8225.209 ±  206.829  ops/ms
BenchmarkFFI.testGetPidJnaDirect  thrpt   10  10257.505 ±  736.135  ops/ms
BenchmarkFFI.testGetPidJni        thrpt   10  77852.899 ± 3167.101  ops/ms
BenchmarkFFI.testGetPidJnr        thrpt   10  58261.657 ± 5187.550  ops/ms
```

**即：JNI > JNR > JNA (Direct Mapping) > JNA (Interface Mapping)**

参见资料：

2013-07 Charles Nutter: Java Native Runtime <http://www.oracle.com/technetwork/java/jvmls2013nutter-2013526.pdf>
