#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include "ListJNI.h"



JNIEXPORT void JNICALL Java_ListJNI_newList(JNIEnv *env, jobject thisObj) {
	long *ptr = malloc(6*sizeof(int));
	*(ptr)=2;
	*(ptr+1)=6;
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	(*env)->SetLongField(env, thisObj, fidNumber, ptr);
}


JNIEXPORT void JNICALL Java_ListJNI_add(JNIEnv *env, jobject thisObj, jint x) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	long ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	int size = *y;
	int maxSize = *(y+1);
	if(size<maxSize){
		*(y+size)=x;
		*y = size+1;
	}else{
		long *newPtr = malloc(maxSize*2*sizeof(int));
		*(newPtr)=size+1;
		*(newPtr+1)=maxSize*2;
		for(int i=2;i<size;i++)
			*(newPtr+i)= *(y+i);
		*(newPtr+size)=x;
		free(ptr);
		jclass thisClass = (*env)->GetObjectClass(env, thisObj);
		jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
		(*env)->SetLongField(env, thisObj, fidNumber, newPtr);
	}
}


JNIEXPORT jint JNICALL Java_ListJNI_get(JNIEnv *env, jobject thisObj, jint x) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	long ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	if(x+2>=*y)
	{
		printf("ArrayIndexOutOfBoundsException\n");
		return 0;
	}
	return *(y+x+2);
}


JNIEXPORT jint JNICALL Java_ListJNI_size(JNIEnv *env, jobject thisObj) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	return (*y)-2;
}


JNIEXPORT void JNICALL Java_ListJNI_clear(JNIEnv *env, jobject thisObj) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	*(y)=2;
	(*env)->SetLongField(env, thisObj, fidNumber, y);
}


JNIEXPORT jboolean JNICALL Java_ListJNI_contains(JNIEnv *env, jobject thisObj, jint x) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	int size = *y;
	for(int i=2;i<size;i++)
		if((*(y+i))==x)
			return JNI_TRUE;
	return JNI_FALSE;
}


JNIEXPORT jint JNICALL Java_ListJNI_indexOf(JNIEnv *env, jobject thisObj, jint x) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	int size = *y;
	for(int i=2;i<size;i++)
		if((*(y+i))==x)
			return i-2;
	return -1;

}


JNIEXPORT jboolean JNICALL Java_ListJNI_isEmpty(JNIEnv *env, jobject thisObj) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	if(*y==2) return JNI_TRUE;
	return JNI_FALSE;
}


JNIEXPORT jint JNICALL Java_ListJNI_lastIndexOf(JNIEnv *env, jobject thisObj, jint x)
{
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	int size = *y;
	for(int i=size-1;i>1;i--)
		if((*(y+i))==x)
			return i-2;
	return -1;
}


JNIEXPORT void JNICALL Java_ListJNI_remove(JNIEnv *env, jobject thisObj, jint x) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	int size = *y;
	if(x==size-3)
		*(y)=size-1;
	else
		*(y+x+2)=NULL;
}


/*
JNIEXPORT void JNICALL Java_ListJNI_removeRange(JNIEnv *env, jobject thisObj, jint from, jint to) {
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "myList", "J");
	jlong ptr = (*env)->GetLongField(env, thisObj, fidNumber);
	long *y = ptr;
	int size = *y;
	if(to==size-3){
		*(y)=size-1-(to-from);}
	else{
		for(int i=from+2;i<to-3;i++)
			*(y+i-2)=NULL;
	}
}*/
