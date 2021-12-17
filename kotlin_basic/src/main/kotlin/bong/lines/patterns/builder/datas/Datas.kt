package bong.lines.patterns.builder.datas

data class Group(
    var name: String,
    var company: Company,
    var members: List<Member>
)

data class Company(
    var name : String = ""
)

data class Member (
    var name : String,
    val alias : String,
    var year: Int
)