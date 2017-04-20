package jvm.internals.jsonassist;

/**
 * Helper interface implemented automatically by Javaassist.
 */
public interface JsonConverter {
	String toJson(Object o);
}