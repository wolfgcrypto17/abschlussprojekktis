import heros.*
import vilans.FinalBoss
import vilans.SecondaryBoss

fun main() {
    val warior = Warrior("mo", 20)
    val archor = Archer("islam", 20)
    val sourcer = Sourcer("ahmed", 20)
    val devill = FinalBoss("Elder Dragon", 10)
    val emp = SecondaryBoss("Emp", 10)
    devill.setSecondary(emp)
    val aidBag = AidBag()
    val gameName = """
        ||| --- --- --- --- --- |||
        ||| --- G O L D E N --- |||
        ||| --- S Y N T A X --- |||
        ||| --- --- --- --- --- |||
    """.trimIndent()
    println(gameName)
    println("1. Play")
    println("2. Exit")
    print("Enter your choice (1/2): ")
    val choice = readLine()
    when (choice) {
        "1" -> {
            println("Let's start the game!")
            // Create heroes and the final boss here
            // Implement the game logic
        }
        "2" -> {
            println("Exiting the game. Goodbye!")
        }
        else -> {
            println("Invalid choice. Please enter 1 to play or 2 to exit.")
        }
    }
    println("You Have Three Chmaps Warrior , Witch and Archer \n they will fight the Elder Dragon and his Emp ")
    println("each time we need you to choose from each one abilities to play the game  ")
    println("lets play ! ")
    while (warior.isAlive || archor.isAlive || sourcer.isAlive && devill.isAlive || emp.isAlive) {
        if (!devill.isAlive && !emp.isAlive )
            break
        if (!warior.isAlive && !archor.isAlive && !sourcer.isAlive)
            break
        devill.SpecialAttack2(null)
        printFightMenu(
            archor,
            warior,
            sourcer,
            devill,
            emp,
            aidBag = aidBag
        ) { selectedChamp, ChampSkill, onWhomC, DragonOrEmp, devillSkill, onWhomD,empAfterCall ->
            val champ = if (selectedChamp == 1) {
                archor
            } else if (selectedChamp == 2) {
                warior
            } else {
                sourcer
            }
            val champAttackWho = if (onWhomC == 1) {
                devill
            } else {
                emp
            }
            val devilAttackWho = if (onWhomD == 1) {
                archor
            } else if (onWhomD == 2) {
                warior
            } else {
                sourcer
            }
            if (ChampSkill == 1) {
                champ.attack1(champAttackWho)
            } else if (ChampSkill == 2) {
                champ.attack2(champAttackWho)
            } else if (ChampSkill == 3) {
                champ.attack3(champAttackWho)
            } else {
                champ.attack4(champAttackWho)
            }
            when (devillSkill) {
                1 -> {
                    if (DragonOrEmp == 1) {
                        devill.attack1(devilAttackWho)
                    } else {
                        emp.attack1(devilAttackWho)
                    }
                }
                2 -> {
                    if (DragonOrEmp == 1) {
                        devill.attack2(devilAttackWho)
                    } else {
                        emp.attack2(devilAttackWho)
                    }
                }
                3 -> {
                    if (DragonOrEmp == 1) {
                        devill.attack3(devilAttackWho)
                    } else {
                        emp.attack3(devilAttackWho)
                    }
                }
                4 -> {
                    if (DragonOrEmp == 1) {
                        devill.attack4(devilAttackWho)
                    } else {
                        emp.attack4(devilAttackWho)
                    }
                }
                5 -> {
                    devill.attack5(devilAttackWho)
                }
                6 -> {
                    devill.attack6(devilAttackWho)
                }
                7 -> {
                    devill.SpecialAttack1(listOf(archor, warior, sourcer))
                }
                8 -> {
                    devill.SpecialAttack2(devilAttackWho)
                }
                9 -> {
                    devill.SpecialAttack3{emp->
                        when (empAfterCall){
                            1 -> {emp.attack1(devilAttackWho)}
                            2 -> {emp.attack2(devilAttackWho)}
                            3 -> {emp.attack3(devilAttackWho)}
                            4 -> {emp.attack4(devilAttackWho)}
                        }
                    }
                }
            }
        }
    }
    if(warior.isAlive || archor.isAlive || sourcer.isAlive){
        println("our champ won :klatschen::sonnenbrille:")
    }else{
        println("The Dragon won :lächelnder_kobold:")
    }
}
fun printFightMenu(
    archer: BaseHero,
    warior: BaseHero,
    sourcer: BaseHero,
    devill: FinalBoss,
    emp: SecondaryBoss,
    aidBag: AidBag,
    whatChoosen: (selectedChamp: Int, ChampSkill: Int, onWhomC: Int, DragonOrEmp: Int, devillSkill: Int, onWhomD: Int, empAfterCallSkill:Int?) -> Unit
) {
    // Dragon skills
    val dragonSkills = listOf(
        "Fire Breath",
        "Tail Whip",
        "Claw Slash",
        "Roar",
        "Bite",
        "Wing Strike",
        "Big Lava",
        "Venom Effect",
        "Call The Emp"
    )
    // Champion skills
    val archerSkills = listOf("Attack", "Special Attack", "Block", "Heal")
    val warriorSkills = listOf("Double Strike", "Magic Missile", "Dodge", "Power Punch")
    val sorcererSkills = listOf("Freezing", "Gravity", "Dizzy", "Cloning")
    // Emp skills
    val empSkills = listOf("heal down", "nock up", "Emp Skill 3", "Emp Skill 4")
    // Display champion skills
    println("\nArcher Skills:")
    for ((index, skill) in archerSkills.withIndex()) {
        println("${index + 1}. $skill")
    }
    println("\nWarrior Skills:")
    for ((index, skill) in warriorSkills.withIndex()) {
        println("${index + 1}. $skill")
    }
    println("\nSorcerer Skills:")
    for ((index, skill) in sorcererSkills.withIndex()) {
        println("${index + 1}. $skill")
    }
    // Display dragon skills
    println("\nDragon Skills:")
    for ((index, skill) in dragonSkills.withIndex()) {
        println("${index + 1}. $skill")
    }
    // Display Emp skills
    println("\nEmp Skills:")
    for ((index, skill) in empSkills.withIndex()) {
        println("${index + 1}. $skill")
    }
    // Get user's choice for champion skills
    print("\nChoose your champion (1 - Archer, 2 - Warrior, 3 - Sorcerer): ")
    val championChoice = readLine()?.toIntOrNull() ?: 0
    val championSkills = when (championChoice) {
        1 -> archerSkills
        2 -> warriorSkills
        3 -> sorcererSkills
        else -> emptyList()
    }
    if (championChoice in 1..3) {
        // Display the chosen champion's skills
        println("\nChampion ${if (championChoice == 1) "Archer" else if (championChoice == 2) "Warrior" else "Sorcerer"} Skills:")
        for ((index, skill) in championSkills.withIndex()) {
            println("${index + 1}. $skill")
        }
        // Get user's choice for champion and dragon skills
        print("Choose your champion's skill or choose to use the bag or vitamin first \n for the skills choose from (1-4)  for the bag press 5 for the vitamin press 6 ")
        var championSkillChoice = readLine()?.toIntOrNull() ?: 0
        if (championSkillChoice == 5) {
            val champ =
                if (championChoice == 1) archer else if (championChoice == 2) warior else sourcer
            aidBag.useBag(champ)
        }
        if (championSkillChoice == 6) {
            val champ =
                if (championChoice == 1) archer else if (championChoice == 2) warior else sourcer
            aidBag.useVitamins(champ)
        }
        if (championSkillChoice == 6 || championSkillChoice == 5) {
            for ((index, skill) in championSkills.withIndex()) {
                println("${index + 1}. $skill")
            }
            // Get user's choice for champion and dragon skills
            print("Choose your champion's skill from (1-4) :  ")
            championSkillChoice = readLine()?.toIntOrNull() ?: 0
        }
        var championSkillChoiceOnWhome = 1
        var devillChoose = 0
        var devillSkillChoice = 0
        var devillSkillChoiceOnWhome = 1
/////
        var dragonSkillChoice = 1
        var empAfterCallSkillChoice = 0
        print("Choose your champion's skill on whom 1- Dragon , 2- Emp :  ")
        championSkillChoiceOnWhome = readLine()?.toIntOrNull() ?: 0
        print("Choose the Devil (1- Dragon , 2- Emp): ")
        devillChoose = readLine()?.toIntOrNull() ?: 0
        val devillName = if (devillChoose == 1) {
            "Dragon"
        } else {
            "Emp"
        }
        val range = if (devillChoose == 1) {
            "(1-9)"
        } else {
            "(1-4)"
        }
        if (devillChoose == 1) {
            // Display dragon skills
            println("\nDragon Skills:")
            for ((index, skill) in dragonSkills.withIndex()) {
                println("${index + 1}. $skill")
            }
        } else {
            // Display Emp skills
            println("\nEmp Skills:")
            for ((index, skill) in empSkills.withIndex()) {
                println("${index + 1}. $skill")
            }
        }
        print("Choose the $devillName 's skill $range: ")
        devillSkillChoice = readLine()?.toIntOrNull() ?: 0
        if (devillSkillChoice ==9){
            print("Choose the Emp 's skill (1-4) : ")
            empAfterCallSkillChoice =readLine()?.toIntOrNull() ?: 0
        }
        print("Choose the $devillName 's skill should be on who ?")
        devillSkillChoiceOnWhome = readLine()?.toIntOrNull() ?: 0
        if (championSkillChoice in 1..4 && dragonSkillChoice in 1..9) {
            val championSkill = championSkills[championSkillChoice - 1]
            val dragonSkill = dragonSkills[dragonSkillChoice - 1]
            println("\nYou chose ${if (championChoice == 1) "Archer" else if (championChoice == 2) "Warrior" else "Sorcerer"}'s skill: $championSkill")
            println(
                "apply skill on : ${
                    if (devillChoose == 1) {
                        "Dragon"
                    } else {
                        "Emp"
                    }
                }"
            )
            println(
                "The ${
                    if (devillChoose == 1) {
                        "Dragon"
                    } else {
                        "Emp"
                    }
                } chose: $devillSkillChoice"
            )
            println(
                "The ${
                    if (devillChoose == 1) {
                        "Dragon"
                    } else {
                        "Emp"
                    }
                } chose on : $devillSkillChoiceOnWhome"
            )
            whatChoosen(
                championChoice,
                championSkillChoice,
                championSkillChoiceOnWhome,
                devillChoose,
                devillSkillChoice,
                devillSkillChoiceOnWhome,
                empAfterCallSkillChoice
            )
            println("archer  " + archer.hp)
            println("warior  " + warior.hp)
            println("sourcer  " + sourcer.hp)
            println("emp  " + emp.hp)
            println("dragon " + devill.hp)
            // Implement the battle logic here
        } else {
            println("Invalid choices. Please choose skills within the specified range.")
        }
    } else {
        println("Invalid champion choice. Please choose a champion within the specified range.")
    }
}


























