package io.github.crackthecodeabhi.kreds

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import java.nio.charset.Charset

/**
 * Any class marked with this annotation is **SAFE** to be called concurrently from coroutines.
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
internal annotation class CoroutineSafe

/**
 * Any class marked with this annotation is **UNSAFE** to be called concurrently from coroutines.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
internal annotation class CoroutineUnsafe


internal fun String.toByteBuf(): ByteBuf = Unpooled.copiedBuffer(this, Charset.defaultCharset())

internal fun ByteBuf.toDefaultCharset(): String = this.toString(Charset.defaultCharset())

public data class FieldValue<out A, out B>(val field: A,val value: B)

internal fun <T> List<T>.second(): T {
    if (isEmpty() || size < 2)
        throw NoSuchElementException("List doesn't have 2nd is empty.")
    return this[1]
}

internal fun <T> List<T>.third(): T {
    if (isEmpty() || size < 3)
        throw NoSuchElementException("List doesn't have 2nd is empty.")
    return this[2]
}