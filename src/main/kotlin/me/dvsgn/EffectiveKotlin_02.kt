package me.dvsgn

// 캡쳐링 테스트

fun 간단_에라토스테네스의_체() {
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()

    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }

    println(primes)
}

fun 시퀀스를_이용한_예() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)

            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }

    println(primes.take(10).toList())
}

fun main() {
    간단_에라토스테네스의_체()
    시퀀스를_이용한_예()
}