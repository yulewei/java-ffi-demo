
通过 [JNI](https://en.wikipedia.org/wiki/Java_Native_Interface) 实现调用 `getpid` vs. 通过 [JNR](https://github.com/jnr/jnr-ffi) 实现调用 `getpid` 代码示例

JNI 示例编译与运行（Mac 环境）：

```
$ mkdir -p target/classes
$ javac src/main/java/com/test/GetPidJNI.java -d "target/classes"
$ javah -cp "target/classes" com.test.GetPidJNI
$ gcc -I $JAVA_HOME/include -I $JAVA_HOME/include/darwin -dynamiclib -o libgetpidjni.dylib com_test_GetPidJNI.c
$ java -Djava.library.path=`pwd` -cp "target/classes" com.test.GetPidJNI
```


JNR 示例编译与运行：

```
$ mvn install
$ java -cp "target/jni-jnr-1.0-SNAPSHOT-jar-with-dependencies.jar" com.test.GetPidJNR
```


参见资料：
2013-07 Charles Nutter: Java Native Runtime <http://www.oracle.com/technetwork/java/jvmls2013nutter-2013526.pdf>
