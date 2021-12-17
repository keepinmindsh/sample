package bong.lines.patterns.builder

val redVelvet =
    group {
        name { "레드벨벳" }
        company {
            name { "SM Entertainment" }
        }
        members {
            member {
                name { "슬기" }
                alias { "곰슬기" }
                year { 1994 }
            }
            member {
                name { "아이린" }
                alias { "얼굴 천재" }
                year { 1991 }
            }
            member {
                name { "웬디" }
                alias { "천사" }
                year { 1994 }
            }
        }
    }

fun main() {
    print("${redVelvet}")
}