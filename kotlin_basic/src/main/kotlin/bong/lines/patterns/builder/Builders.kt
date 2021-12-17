package bong.lines.patterns.builder

import bong.lines.patterns.builder.datas.Company
import bong.lines.patterns.builder.datas.Group
import bong.lines.patterns.builder.datas.Member


class MemberBuilder {
    private var name: String = ""
    private var alias: String = ""
    private var year: Int = 0

    fun name(lambda: () -> String) {
        name(lambda)
    }

    fun alias(lambda: () -> String) {
        alias(lambda)
    }

    fun year(lambda: () -> Int) {
        year(lambda)
    }

    fun build() = Member(name, alias, year)
}


class MemberListBuilder {
    private val employeeList = mutableListOf<Member>()

    fun member(lambda: MemberBuilder.() -> Unit) =
        employeeList.add(MemberBuilder().apply(lambda).build())

    fun build() = employeeList
}

class CompanyBuilder {
    private var name = ""

    fun name(lambda: () -> String) {
        this.name = lambda()
    }

    fun build() = Company(name)
}

class GroupBuilder {

    private var name = ""

    private var company = Company("")

    private val employees = mutableListOf<Member>()

    fun name(lambda: () -> String) {
        name = lambda()
    }

    fun company(lambda: CompanyBuilder.() -> Unit) {
        company = CompanyBuilder().apply(lambda).build()
    }

    fun members(lambda: MemberListBuilder.() -> Unit) =
        employees.addAll(MemberListBuilder().apply(lambda).build())

    fun build() = Group(name, company, employees)
}


fun group(lambda: GroupBuilder.() -> Unit): Group {
    return GroupBuilder().apply(lambda).build()
}

