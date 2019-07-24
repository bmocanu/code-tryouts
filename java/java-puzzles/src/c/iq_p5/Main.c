#include <jni.h>
#include "Main.h"


JNIEXPORT jboolean JNICALL Java_ro_bmocanu_javapuzzles_iq_p5_Main_changeToRisk
  (JNIEnv *env, jclass cls, jstring theString) {
	jboolean isCopy;
	jchar *chars = (*env)->GetStringCritical(env, theString, &isCopy);
	chars[0] = 'r';
	(*env)->ReleaseStringCritical(env, theString, chars);
	return isCopy;
}