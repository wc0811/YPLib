package com.yp.yplib.ext

fun String?.null2Empty(): String {
    return when {
        this == null -> ""
        this.isBlank() -> ""
        this == "null" -> ""
        else -> ""
    }
}
