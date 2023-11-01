package heros

import vilans.FinalBoss

abstract class BaseHero(var name: String, var hp: Int) {
    private val halfHP = hp / 0.5
    internal var damage = 10
    internal var basehp = hp
    abstract fun attack1(target1: FinalBoss)
    abstract fun attack2(target1: FinalBoss)
    abstract fun attack3(target1: FinalBoss)
    abstract fun attack4(target1: FinalBoss)
    val isAlive: Boolean
        get() = hp > 0
    fun restoreHealth() {
        hp = (halfHP + hp).toInt()
    }
    fun getVitamins() {
        // raise the damage for all his abilities with 10%
        this.damage = this.damage + (this.damage * 0.1).toInt()
    }
}











