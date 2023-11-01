package heros

import heros.BaseHero

class AidBag {
    private var usedBag = false
    private var usedVitamin = false
    fun useBag(hero: BaseHero) {
        if (!usedBag) {
            // Implement the behavior of using the bag here
            hero.restoreHealth()
            usedBag = true
        }
    }
    fun useVitamins(hero: BaseHero) {
        if (!usedBag) {
            // Implement the behavior of using the bag here
            hero.getVitamins()
            usedVitamin = true
        }
    }
}