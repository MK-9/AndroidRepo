package ir.divar.network.models

sealed class Result<out T : Any> {
    data class OnSuccess<out T : Any>(val data: T) : Result<T>()
    data class OnError(val msg: String?) : Result<Nothing>()
    data class InProgress(val state: Boolean) : Result<Nothing>()
}