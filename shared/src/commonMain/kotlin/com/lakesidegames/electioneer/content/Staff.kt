package com.lakesidegames.electioneer.content

import com.lakesidegames.electioneer.engine.CandidateId
import com.lakesidegames.electioneer.engine.GameState
import kotlinx.serialization.Serializable

// Campaign staff: hire up to 3 from a pool of 8 at setup. Each gives one
// passive bonus; the in-flight multipliers are read by the engine via
// staffEffects(). Port of src/content/staff.ts.
@Serializable
data class StaffEffectsDef(
    val maxActions: Int = 0,
    val adMult: Double = 1.0,
    val fundraiseMult: Double = 1.0,
    val oppoShield: Double = 0.0,
    val debatePrepBonus: Double = 0.0,
    val traitBonuses: Map<String, Double> = emptyMap(),
)

@Serializable
data class StaffDef(
    val id: String,
    val name: String,
    val role: String,
    val blurb: String,
    val salaryPerWeek: Double,
    val loyalty: Double,
    val effects: StaffEffectsDef,
)

val STAFF_POOL: List<StaffDef> = listOf(
    StaffDef(
        "field_director", "Ray Ortega", "Field Director",
        "A machine of clipboards and county maps. One more thing gets done every single week.",
        400_000.0, 55.0, StaffEffectsDef(maxActions = 1),
    ),
    StaffDef(
        "media_guru", "Dana Whitfield", "Media Strategist",
        "Cut her teeth on Super Bowl spots. Your ad dollars simply buy more.",
        550_000.0, 60.0, StaffEffectsDef(adMult = 1.12),
    ),
    StaffDef(
        "finance_chair", "Marcus Boone", "Finance Chair",
        "Knows every bundler from Palo Alto to Palm Beach. Fundraisers close bigger.",
        350_000.0, 50.0, StaffEffectsDef(fundraiseMult = 1.15),
    ),
    StaffDef(
        "debate_coach", "Prof. Elena Vasquez", "Debate Coach",
        "Drills you until the zingers are muscle memory. Sharper on stage, week one.",
        300_000.0, 70.0,
        StaffEffectsDef(
            debatePrepBonus = 3.0,
            traitBonuses = mapOf("debatePrep" to 6.0, "debatingSkill" to 4.0),
        ),
    ),
    StaffDef(
        "spin_doctor", "Tommy Callahan", "Rapid Response Director",
        "Kills opposition hits before the second news cycle. Their dirt sticks less.",
        450_000.0, 45.0, StaffEffectsDef(oppoShield = 0.15),
    ),
    StaffDef(
        "pollster", "Dr. Ingrid Chen", "Chief Pollster",
        "Her crosstabs read like prophecy. Your message lands closer to the mark.",
        400_000.0, 65.0,
        StaffEffectsDef(adMult = 1.05, traitBonuses = mapOf("policyKnowledge" to 4.0)),
    ),
    StaffDef(
        "body_man", "Petey Sullivan", "Body Man",
        "Coffee, briefings, and a sixth sense for when you need a nap. The candidate stays fresh.",
        150_000.0, 90.0,
        StaffEffectsDef(traitBonuses = mapOf("energy" to 6.0)),
    ),
    StaffDef(
        "veteran_manager", "Claudia Marsh", "Campaign Manager",
        "Three cycles, two upsets. Steadies the whole operation with a bit of everything.",
        600_000.0, 55.0,
        StaffEffectsDef(maxActions = 1, fundraiseMult = 1.05, adMult = 1.04),
    ),
)

val STAFF_BY_ID: Map<String, StaffDef> = STAFF_POOL.associateBy { it.id }

const val MAX_STAFF = 3

@Serializable
data class StaffEffects(
    val maxActions: Int = 0,
    val adMult: Double = 1.0,
    val fundraiseMult: Double = 1.0,
    val oppoShield: Double = 0.0,
    val debatePrepBonus: Double = 0.0,
    val salaryPerWeek: Double = 0.0,
)

// Aggregate passive effects of a ticket's current staff.
fun staffEffects(game: GameState, candidate: CandidateId): StaffEffects {
    var maxActions = 0
    var adMult = 1.0
    var fundraiseMult = 1.0
    var oppoShield = 0.0
    var debatePrepBonus = 0.0
    var salaryPerWeek = 0.0
    for (id in game.staff?.get(candidate.serial) ?: emptyList()) {
        val s = STAFF_BY_ID[id] ?: continue
        maxActions += s.effects.maxActions
        adMult *= s.effects.adMult
        fundraiseMult *= s.effects.fundraiseMult
        oppoShield += s.effects.oppoShield
        debatePrepBonus += s.effects.debatePrepBonus
        salaryPerWeek += s.salaryPerWeek
    }
    return StaffEffects(maxActions, adMult, fundraiseMult, oppoShield, debatePrepBonus, salaryPerWeek)
}
