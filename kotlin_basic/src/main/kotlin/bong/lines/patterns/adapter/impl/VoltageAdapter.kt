package bong.lines.patterns.adapter.impl

import bong.lines.patterns.adapter.inf.V110
import bong.lines.patterns.adapter.inf.V220

class VoltageAdapter(val v220: V220) : V110 {
    override fun useElectric() {
        v220.useElectric()
    }
}
