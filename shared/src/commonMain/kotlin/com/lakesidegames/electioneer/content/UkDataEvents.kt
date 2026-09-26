package com.lakesidegames.electioneer.content

import com.lakesidegames.electioneer.engine.AllocationStrategy
import com.lakesidegames.electioneer.engine.AllocationStrategyId
import com.lakesidegames.electioneer.engine.MajorityRule
import com.lakesidegames.electioneer.engine.PartyDef
import com.lakesidegames.electioneer.engine.PartyScope
import com.lakesidegames.electioneer.engine.PoliticalSystem

// GENERATED from src/content (web.pin source of truth). Do not hand-edit;
// regenerate. Split across files to stay under the JVM method-size limit.
val UK_EVENTS: List<UkEvent> = listOf(
    UkEvent(id = "manifesto_hit", headline = "{party}'s manifesto launch lands well with voters", role = "any", weight = 3.0, appeal = 0.035, momentum = 8.0),
    UkEvent(id = "manifesto_miss", headline = "{party} manifesto unravels under scrutiny", role = "leader", weight = 2.0, appeal = -0.04, momentum = -10.0),
    UkEvent(id = "debate_win", headline = "{party} leader judged the winner of the TV debate", role = "any", weight = 3.0, appeal = 0.03, momentum = 12.0),
    UkEvent(id = "gaffe", headline = "{party} leader's campaign-trail gaffe dominates the news", role = "any", weight = 3.0, appeal = -0.035, momentum = -9.0),
    UkEvent(id = "tabloid", headline = "A major newspaper swings behind {party}", role = "any", weight = 2.0, appeal = 0.03),
    UkEvent(id = "scandal", headline = "Scandal engulfs a {party} candidate", role = "leader", weight = 2.0, appeal = -0.03, momentum = -7.0),
    UkEvent(id = "surge_poll", headline = "Shock poll shows {party} surging", role = "challenger", weight = 2.0, appeal = 0.025, momentum = 14.0),
    UkEvent(id = "economy_good", headline = "Upbeat economic figures lift the governing mood for {party}", role = "leader", weight = 2.0, appeal = 0.025),
    UkEvent(id = "nhs_row", headline = "An NHS winter-crisis row hurts {party}", role = "leader", weight = 2.0, appeal = -0.03, momentum = -6.0),
    UkEvent(id = "rally_energy", headline = "A huge {party} rally electrifies the base", role = "player", weight = 2.0, appeal = 0.025, momentum = 10.0),
    UkEvent(id = "endorsement", headline = "A popular figure endorses {party}", role = "any", weight = 2.0, appeal = 0.02, momentum = 5.0),
    UkEvent(id = "u_turn", headline = "{party} forced into an embarrassing policy U-turn", role = "any", weight = 2.0, appeal = -0.025, momentum = -6.0),
    UkEvent(id = "tv_debate_call", headline = "The networks offer {party} a head-to-head debate slot", role = "player", weight = 4.0, prompt = "The broadcasters want a head-to-head. How do you play it?", choices = listOf(UkEventChoice(id = "accept_attack", text = "Accept and go on the attack", resultText = "You land blows and take a few. The overnight polls twitch your way.", appeal = 0.03, momentum = 10.0, rivalAppeal = -0.015), UkEventChoice(id = "accept_safe", text = "Accept and play it safe", resultText = "A steady, on-message night. No gaffes, no fireworks.", appeal = 0.015, momentum = 4.0), UkEventChoice(id = "decline", text = "Decline: protect the lead, avoid the ambush", resultText = "You dodge the studio lights. The press calls it cowardice; your base calls it discipline.", appeal = -0.01, momentum = -4.0))),
    UkEvent(id = "tabloid_splash", headline = "A Sunday tabloid is sitting on a story about {party}", role = "player", weight = 3.0, prompt = "A red-top has dirt. What's the play?", choices = listOf(UkEventChoice(id = "prebut", text = "Pre-but: get your version out first", resultText = "You blunt the splash. The story still runs, softer and on your terms.", appeal = -0.01, momentum = -2.0), UkEventChoice(id = "ignore", text = "Ignore it and stay on message", resultText = "The splash dominates a news cycle. Your grid holds, barely.", appeal = -0.025, momentum = -6.0), UkEventChoice(id = "sue", text = "Threaten legal action and dare them", resultText = "They blink on the worst claims. You look thin-skinned to everyone else.", appeal = -0.015, momentum = -3.0))),
    UkEvent(id = "manifesto_fork", headline = "{party}'s manifesto committee is split on the big pledge", role = "player", weight = 3.0, prompt = "The draft is ready. Which way do you push the manifesto?", choices = listOf(UkEventChoice(id = "bold", text = "Go bold with a defining, risky pledge", resultText = "The base roars. The spreadsheets at HQ look nervous.", appeal = 0.035, momentum = 12.0), UkEventChoice(id = "cautious", text = "Play it cautious: Ming vase politics", resultText = "No hostages to fortune. Also no spark.", appeal = 0.01, momentum = 2.0), UkEventChoice(id = "contrast", text = "Make it a contrast document against the rival", resultText = "You define them more than yourself, and it lands.", appeal = 0.02, momentum = 6.0, rivalAppeal = -0.02))),
    UkEvent(id = "ground_surge", headline = "Activists beg {party} HQ for a late ground-game surge", role = "player", weight = 3.0, prompt = "Do you empty the war chest into the final ground push?", choices = listOf(UkEventChoice(id = "all_in", text = "All in: flood the marginals", resultText = "Doors knocked, leaflets out. The machine is humming.", appeal = 0.025, momentum = 8.0), UkEventChoice(id = "balanced", text = "Balanced: keep powder dry for broadcast", resultText = "A competent final week. Nothing wasted, nothing spectacular.", appeal = 0.012, momentum = 3.0), UkEventChoice(id = "air_war", text = "Pivot to the air war instead", resultText = "The ads blanket the regions. Field organisers grumble.", appeal = 0.018, momentum = 5.0)))
)

val UK_EVENT_CHANCE: Double = 0.7
