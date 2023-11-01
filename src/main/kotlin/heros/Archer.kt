package heros

import vilans.FinalBoss

class Archer(name: String, hp: Int)  : BaseHero(name, hp) {
    override fun attack1(target1: FinalBoss) {
        if (target1.hp - 10 < 0) {
            target1.hp = 0
        } else {
            target1.hp = target1.hp - damage
        }
    }
    override fun attack2(target1: FinalBoss) {
        if (target1.hp - 10 < 0) {
            target1.hp = 0
        } else {
            target1.hp = target1.hp - damage
        }
    }
    override fun attack3(target1: FinalBoss) {
        if (target1.hp - 10 < 0) {
            target1.hp = 0
        } else {
            target1.hp = target1.hp - damage
        }
    }
    override fun attack4(target1: FinalBoss) {
        if (target1.hp - 10 < 0) {
            target1.hp = 0
        } else {
            target1.hp = target1.hp - damage
        }
    }
}