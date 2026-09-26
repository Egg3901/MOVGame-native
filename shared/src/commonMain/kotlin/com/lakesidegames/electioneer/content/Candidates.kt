package com.lakesidegames.electioneer.content

import com.lakesidegames.electioneer.engine.Candidate
import com.lakesidegames.electioneer.engine.CandidateId
import com.lakesidegames.electioneer.engine.CandidateTraits
import com.lakesidegames.electioneer.engine.Party

// The two tickets. issuePositions: -1 (left) .. +1 (right). Traits 0..100
// modify action effectiveness and event odds, never the vote directly.
// Port of src/content/candidates.ts (data subset needed by the engine).
val CANDIDATES: Map<CandidateId, Candidate> = mapOf(
    CandidateId.DEM to Candidate(
        id = CandidateId.DEM,
        name = "Joe Biden",
        shortName = "Biden",
        party = Party.DEMOCRATIC,
        runningMate = "Kamala Harris",
        color = "#2563eb",
        traits = CandidateTraits(
            charisma = 62.0, energy = 55.0, debatePrep = 70.0, intelligence = 68.0,
            policyKnowledge = 92.0, debatingSkill = 64.0, fundraisingProwess = 78.0,
        ),
        issuePositions = mutableMapOf(
            "economy" to -0.25, "covid_response" to -0.55, "healthcare" to -0.45,
            "immigration" to -0.35, "race_policing" to -0.4, "climate" to -0.5,
            "taxes" to -0.3, "law_and_order" to -0.1, "abortion" to -0.5,
            "trade" to -0.05,
        ),
        baseFavorability = mapOf(
            "black" to 0.35, "college_white" to 0.12,
            "suburban_women" to 0.18, "seniors" to 0.05,
        ),
    ),
    CandidateId.REP to Candidate(
        id = CandidateId.REP,
        name = "Donald Trump",
        shortName = "Trump",
        party = Party.REPUBLICAN,
        runningMate = "Mike Pence",
        color = "#dc2626",
        traits = CandidateTraits(
            charisma = 74.0, energy = 70.0, debatePrep = 60.0, intelligence = 38.0,
            policyKnowledge = 58.0, debatingSkill = 66.0, fundraisingProwess = 70.0,
        ),
        issuePositions = mutableMapOf(
            "economy" to 0.5, "covid_response" to 0.5, "healthcare" to 0.4,
            "immigration" to 0.75, "race_policing" to 0.55, "climate" to 0.6,
            "taxes" to 0.55, "law_and_order" to 0.7, "abortion" to 0.5,
            "trade" to 0.45,
        ),
        baseFavorability = mapOf(
            "noncollege_white" to 0.3, "seniors" to 0.08,
        ),
    ),
)

val OPPONENT_OF: Map<CandidateId, CandidateId> = mapOf(
    CandidateId.DEM to CandidateId.REP,
    CandidateId.REP to CandidateId.DEM,
)
