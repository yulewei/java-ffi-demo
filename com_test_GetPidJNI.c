#include "com_test_GetPidJNI.h"

JNIEXPORT jlong JNICALL
Java_com_test_GetPidJNI_getpid (JNIEnv * env, jclass c) {
    return getpid();
}
