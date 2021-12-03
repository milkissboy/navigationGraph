package com.hyk.navigationGrape.extends

private const val inner_empty = ""
private const val inner_space = " "
private const val inner_comma = ","
private const val inner_carriage_return = "\n"
private const val inner_point = " ・ "
private const val inner_point_fit = "・"

val String.Companion.empty: String
    get() = inner_empty

val String.Companion.space: String
    get() = inner_space

val String.Companion.comma: String
    get() = inner_comma

val String.Companion.carriageReturn: String
    get() = inner_carriage_return

val String.Companion.point: String
    get() = inner_point

val String.Companion.pointFit: String
    get() = inner_point_fit

// String 여백 제거
//fun String.removeEmpty(): String = this.replace(inner_space, inner_empty)
fun String.removeEmpty(): String = this.replace(Regex(inner_space), inner_empty)

// 숫자형태 체크
fun String.checkNumeric(): Boolean = this.toDoubleOrNull() != null