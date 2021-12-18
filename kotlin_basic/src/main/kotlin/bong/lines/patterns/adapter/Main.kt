package bong.lines.patterns.adapter

import bong.lines.patterns.adapter.impl.KoreanElectricProduct
import bong.lines.patterns.adapter.impl.VoltageAdapter
import bong.lines.patterns.adapter.inf.V110
import bong.lines.patterns.adapter.inf.V220

fun main() {
    var v220: V220 = KoreanElectricProduct()

    var voltageAdapter : V110 = VoltageAdapter(v220)

    voltageAdapter.useElectric()
}
