package com.lakesidegames.electioneer.content

import com.lakesidegames.electioneer.engine.BlocId
import kotlin.math.ln
import kotlin.math.max
import kotlin.math.min
import kotlinx.serialization.Serializable

// Bloc archetypes: national share, turnout, 2020 lean, and the issue profile
// (how much each bloc cares + its ideal left(-1)/right(+1) position).
// Port of src/content/blocs.ts. Phase 2 will load content from JSON bundles
// with web.pin as source of truth; these tables seed that migration.
@Serializable
data class BlocArchetype(
    val id: BlocId,
    val name: String,
    val nationalShare: Double,
    val turnoutPropensity: Double,
    val nationalDemShare: Double,
    val issueWeights: Map<String, Double>,
    val idealPositions: Map<String, Double>,
    val traitSensitivity: Double,
)

private fun arch(
    id: BlocId,
    name: String,
    share: Double,
    turnout: Double,
    demShare: Double,
    sensitivity: Double,
    weights: Map<String, Double>,
    ideals: Map<String, Double>,
) = BlocArchetype(id, name, share, turnout, demShare, weights, ideals, sensitivity)

val BLOCS: Map<BlocId, BlocArchetype> = listOf(
    arch(
        BlocId.NONCOLLEGE_WHITE, "Working-class white voters", 0.3, 0.62, 0.36, 0.55,
        mapOf(
            "economy" to 0.9, "trade" to 0.7, "immigration" to 0.7,
            "law_and_order" to 0.65, "healthcare" to 0.5, "covid_response" to 0.45,
        ),
        mapOf(
            "economy" to 0.35, "trade" to 0.4, "immigration" to 0.55,
            "law_and_order" to 0.6, "healthcare" to 0.0, "covid_response" to 0.3,
            "climate" to 0.4,
        ),
    ),
    arch(
        BlocId.COLLEGE_WHITE, "College-educated white voters", 0.18, 0.72, 0.52, 0.45,
        mapOf(
            "economy" to 0.7, "healthcare" to 0.65, "climate" to 0.6,
            "covid_response" to 0.7, "abortion" to 0.5, "taxes" to 0.55,
        ),
        mapOf(
            "economy" to 0.05, "healthcare" to -0.2, "climate" to -0.35,
            "covid_response" to -0.3, "abortion" to -0.3, "taxes" to 0.1,
            "immigration" to -0.1,
        ),
    ),
    arch(
        BlocId.SUBURBAN_WOMEN, "Suburban women", 0.09, 0.7, 0.55, 0.6,
        mapOf(
            "covid_response" to 0.85, "healthcare" to 0.75, "abortion" to 0.6,
            "law_and_order" to 0.55, "economy" to 0.65,
        ),
        mapOf(
            "covid_response" to -0.4, "healthcare" to -0.3, "abortion" to -0.4,
            "law_and_order" to 0.15, "economy" to -0.05, "race_policing" to -0.2,
        ),
    ),
    arch(
        BlocId.BLACK, "Black voters", 0.12, 0.6, 0.9, 0.4,
        mapOf(
            "race_policing" to 0.9, "healthcare" to 0.7, "economy" to 0.7,
            "covid_response" to 0.7,
        ),
        mapOf(
            "race_policing" to -0.6, "healthcare" to -0.45, "economy" to -0.25,
            "covid_response" to -0.4, "law_and_order" to -0.3,
        ),
    ),
    arch(
        BlocId.HISPANIC, "Hispanic & Latino voters", 0.11, 0.52, 0.62, 0.5,
        mapOf(
            "economy" to 0.85, "immigration" to 0.7, "healthcare" to 0.6,
            "covid_response" to 0.6,
        ),
        mapOf(
            "economy" to -0.1, "immigration" to -0.35, "healthcare" to -0.3,
            "covid_response" to -0.25, "law_and_order" to 0.1,
        ),
    ),
    arch(
        BlocId.ASIAN_OTHER, "Asian American & other voters", 0.05, 0.58, 0.65, 0.45,
        mapOf(
            "economy" to 0.8, "healthcare" to 0.6, "immigration" to 0.55,
            "covid_response" to 0.6,
        ),
        mapOf(
            "economy" to -0.05, "healthcare" to -0.25, "immigration" to -0.25,
            "covid_response" to -0.3,
        ),
    ),
    arch(
        BlocId.SENIORS, "Seniors (65+)", 0.1, 0.75, 0.48, 0.5,
        mapOf(
            "covid_response" to 0.9, "healthcare" to 0.8, "economy" to 0.6,
            "law_and_order" to 0.6,
        ),
        mapOf(
            "covid_response" to -0.15, "healthcare" to -0.1, "economy" to 0.2,
            "law_and_order" to 0.4, "immigration" to 0.25,
        ),
    ),
    arch(
        BlocId.YOUTH, "Young voters (18-29)", 0.05, 0.46, 0.6, 0.5,
        mapOf(
            "climate" to 0.85, "race_policing" to 0.75, "healthcare" to 0.6,
            "economy" to 0.6,
        ),
        mapOf(
            "climate" to -0.6, "race_policing" to -0.55, "healthcare" to -0.5,
            "economy" to -0.3, "abortion" to -0.4,
        ),
    ),
).associateBy { it.id }

// Bloc ids in content order (TS: Object.keys(BLOCS)).
val BLOC_IDS: List<BlocId> = BLOCS.keys.toList()

// Logit helper (exported for the state-shift solver in setup).
fun logit(p: Double): Double {
    val clamped = min(0.999, max(0.001, p))
    return ln(clamped / (1 - clamped))
}
