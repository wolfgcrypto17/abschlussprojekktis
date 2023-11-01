package vilans

import heros.BaseHero

class SecondaryBoss(name: String, hp: Int) : FinalBoss(name, hp) {
    override fun attack1(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    override fun attack2(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    override fun attack3(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    override fun attack4(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
}