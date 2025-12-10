




#include <jni.h>

extern "C"
  JNIEXPORT jstring JNICALL
Java_com_example_helloworld_MainActivity_stringFromJNI(JNIEnv* env, jobject /* this */) {
    return env->NewStringUTF("Hello from C++");
}
                      
