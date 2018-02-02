#include "com_test_GetPidJni.h"

JNIEXPORT jlong JNICALL
Java_com_test_GetPidJni_getpid (JNIEnv * env, jclass c) {
    return getpid();
}
