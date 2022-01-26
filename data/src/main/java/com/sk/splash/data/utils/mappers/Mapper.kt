package com.sk.splash.data.utils.mappers

interface Mapper<FROM, TO> {
    fun map(from: FROM): TO
    fun map(from: List<FROM>): List<TO> = from.map(::map)
}

interface Mapper2<FROM, TO, EXTRA> {
    fun map(from: FROM, extra: EXTRA): TO
    fun map(from: List<FROM>, extra: EXTRA): List<TO> = from.map { map(it, extra) }
}

interface ReverseMapper<FROM, TO> : Mapper<FROM, TO> {
    fun mapBack(to: TO): FROM
    fun mapBack(to: List<TO>): List<FROM> = to.map(::mapBack)
}

interface ReverseMapper2<FROM, TO, EXTRA> : Mapper<FROM, TO> {
    fun mapBack(to: TO, extra: EXTRA): FROM
    fun mapBack(to: List<TO>, extra: EXTRA): List<FROM> = to.map { mapBack(it, extra) }
}

