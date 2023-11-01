package vilans

import heros.BaseHero

open class FinalBoss(var name: String, var hp: Int) {
    internal var callSecondary = false
    internal var damage = 10
    private var perRoundChamp: BaseHero? = null
    private var emp: SecondaryBoss? = null
    val isAlive: Boolean
        get() = hp > 0
    fun setSecondary (devil: SecondaryBoss){
        emp=devil
    }
    // Abstract attack modes
    open fun attack1(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    open fun attack2(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    open fun attack3(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    open fun attack4(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    fun attack5(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    fun attack6(target: BaseHero) {
        if (target.hp - 10 < 0) {
            target.hp = 0
        } else {
            target.hp = target.hp - damage
        }
    }
    fun SpecialAttack1(target: List<BaseHero>) {
        // Define the behavior that damage all heroes
        target.forEach { target ->
            if (target.hp - 10 < 0) {
                target.hp = 0
            } else {
                target.hp = target.hp - damage
            }
        }
    }
    fun SpecialAttack2(target: BaseHero?) {
        // Define the behavior for attack damage until  20% health by 10% each round
        perRoundChamp = target
        if (perRoundChamp == null) {
            return
        }
        if (perRoundChamp!!.hp < perRoundChamp!!.basehp * 0.2) {
            return
        } else {
            perRoundChamp!!.hp = perRoundChamp!!.hp - (perRoundChamp!!.hp * 0.1).toInt()
        }
    }
    fun SpecialAttack3(empAttack:(emp: SecondaryBoss)->Unit) {
        // Define the behavior for attack call the second boss
        if (!callSecondary) {
            println("You can use it once a war ")
            empAttack(emp!!)
        } else {
            callSecondary = true
        }
    }
}























