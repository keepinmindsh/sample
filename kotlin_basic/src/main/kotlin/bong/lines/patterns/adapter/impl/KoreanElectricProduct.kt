package bong.lines.patterns.adapter.impl

import bong.lines.patterns.adapter.inf.V220

class KoreanElectricProduct : V220 {
    override fun useElectric() {
        print("한국의 220 볼트 전기 제품을 사용합니다.")
    }
}
