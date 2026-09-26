package com.lakesidegames.electioneer.content

import com.lakesidegames.electioneer.engine.AllocationStrategy
import com.lakesidegames.electioneer.engine.AllocationStrategyId
import com.lakesidegames.electioneer.engine.MajorityRule
import com.lakesidegames.electioneer.engine.PartyDef
import com.lakesidegames.electioneer.engine.PartyScope
import com.lakesidegames.electioneer.engine.PoliticalSystem

// GENERATED from src/content (web.pin source of truth). Do not hand-edit;
// regenerate. Split across files to stay under the JVM method-size limit.
val UK_ABSTAINING: List<String> = listOf("sf")

val UK_SYSTEM = PoliticalSystem(
    id = "UK", label = "United Kingdom",
    parties = listOf(PartyDef(id = "con", name = "Conservative Party", shortName = "Con", color = "#0087dc", scope = PartyScope.NATIONAL), PartyDef(id = "lab", name = "Labour Party", shortName = "Lab", color = "#e4003b", scope = PartyScope.NATIONAL), PartyDef(id = "ld", name = "Liberal Democrats", shortName = "LD", color = "#faa61a", scope = PartyScope.NATIONAL), PartyDef(id = "ref", name = "Reform UK", shortName = "Reform", color = "#12b6cf", scope = PartyScope.NATIONAL), PartyDef(id = "grn", name = "Green Party", shortName = "Green", color = "#02a95b", scope = PartyScope.NATIONAL), PartyDef(id = "snp", name = "Scottish National Party", shortName = "SNP", color = "#fdf38e", scope = PartyScope.SCOTLAND), PartyDef(id = "pc", name = "Plaid Cymru", shortName = "Plaid", color = "#005b54", scope = PartyScope.WALES), PartyDef(id = "dup", name = "Democratic Unionist Party", shortName = "DUP", color = "#d46a4c", scope = PartyScope.NORTHERN_IRELAND), PartyDef(id = "sf", name = "Sinn Féin", shortName = "SF", color = "#326760", scope = PartyScope.NORTHERN_IRELAND), PartyDef(id = "uup", name = "Ulster Unionist Party", shortName = "UUP", color = "#48a5ee", scope = PartyScope.NORTHERN_IRELAND), PartyDef(id = "sdlp", name = "Social Democratic & Labour Party", shortName = "SDLP", color = "#99ff66", scope = PartyScope.NORTHERN_IRELAND), PartyDef(id = "apni", name = "Alliance Party", shortName = "Alliance", color = "#f6cb2f", scope = PartyScope.NORTHERN_IRELAND), PartyDef(id = "oth", name = "Others / Independents", shortName = "Other", color = "#9aa0a6", scope = PartyScope.NATIONAL)),
    allocation = AllocationStrategy(id = AllocationStrategyId.REGIONAL_SEATS_CURVE, label = "First-past-the-post (regional seats curve)", unit = "seat"),
    majority = MajorityRule(total = 650, threshold = 326),
)

val UK_REGIONS: List<UkRegionMeta> = listOf(
    UkRegionMeta(id = "NE", name = "North East", abbr = "NE", nation = "england", seats = 27, electorate = 1100.0, profile = mapOf("workingclass" to 1.3, "graduate" to 0.8, "pensioner" to 1.1)),
    UkRegionMeta(id = "NW", name = "North West", abbr = "NW", nation = "england", seats = 73, electorate = 3000.0, profile = mapOf("workingclass" to 1.2, "renter" to 1.1)),
    UkRegionMeta(id = "YH", name = "Yorkshire & the Humber", abbr = "Y&H", nation = "england", seats = 54, electorate = 2200.0, profile = mapOf("workingclass" to 1.2)),
    UkRegionMeta(id = "EM", name = "East Midlands", abbr = "EM", nation = "england", seats = 47, electorate = 2000.0, profile = mapOf("workingclass" to 1.15, "homeowner" to 1.1)),
    UkRegionMeta(id = "WM", name = "West Midlands", abbr = "WM", nation = "england", seats = 57, electorate = 2300.0, profile = mapOf("workingclass" to 1.15)),
    UkRegionMeta(id = "EE", name = "East of England", abbr = "East", nation = "england", seats = 61, electorate = 2700.0, profile = mapOf("homeowner" to 1.2, "pensioner" to 1.1)),
    UkRegionMeta(id = "LON", name = "London", abbr = "London", nation = "england", seats = 75, electorate = 3300.0, profile = mapOf("young" to 1.3, "graduate" to 1.4, "renter" to 1.4, "pensioner" to 0.7, "homeowner" to 0.7)),
    UkRegionMeta(id = "SE", name = "South East", abbr = "SE", nation = "england", seats = 91, electorate = 4100.0, profile = mapOf("homeowner" to 1.25, "graduate" to 1.1, "pensioner" to 1.1)),
    UkRegionMeta(id = "SW", name = "South West", abbr = "SW", nation = "england", seats = 58, electorate = 2700.0, profile = mapOf("homeowner" to 1.2, "pensioner" to 1.25)),
    UkRegionMeta(id = "SCO", name = "Scotland", abbr = "Scot", nation = "scotland", seats = 57, electorate = 2600.0),
    UkRegionMeta(id = "WAL", name = "Wales", abbr = "Wales", nation = "wales", seats = 32, electorate = 1300.0, profile = mapOf("workingclass" to 1.2, "pensioner" to 1.1)),
    UkRegionMeta(id = "NI", name = "Northern Ireland", abbr = "NI", nation = "northern_ireland", seats = 18, electorate = 700.0)
)

val UK_REGIONS_BY_ID: Map<String, UkRegionMeta> = UK_REGIONS.associateBy { it.id }

val UK_TOTAL_SEATS: Int = UK_REGIONS.sumOf { it.seats }

val UK_BLOCS: List<UkBlocDef> = listOf(
    UkBlocDef(id = "young", name = "Young voters (18-29)", share = 0.18, turnoutPropensity = 0.55, tilt = mapOf("lab" to 0.35, "grn" to 0.45, "ld" to 0.1, "con" to -0.5, "ref" to -0.4)),
    UkBlocDef(id = "graduate", name = "Graduates", share = 0.3, turnoutPropensity = 0.74, tilt = mapOf("lab" to 0.2, "ld" to 0.3, "grn" to 0.25, "con" to -0.15, "ref" to -0.6)),
    UkBlocDef(id = "workingclass", name = "Non-graduate workers (C2DE)", share = 0.34, turnoutPropensity = 0.6, tilt = mapOf("ref" to 0.55, "con" to 0.1, "lab" to 0.1, "grn" to -0.3, "ld" to -0.25)),
    UkBlocDef(id = "homeowner", name = "Homeowners", share = 0.3, turnoutPropensity = 0.74, tilt = mapOf("con" to 0.4, "ref" to 0.15, "lab" to -0.2, "grn" to -0.2)),
    UkBlocDef(id = "renter", name = "Renters", share = 0.24, turnoutPropensity = 0.58, tilt = mapOf("lab" to 0.3, "grn" to 0.25, "con" to -0.35, "ref" to -0.1)),
    UkBlocDef(id = "pensioner", name = "Pensioners (65+)", share = 0.22, turnoutPropensity = 0.8, tilt = mapOf("con" to 0.5, "ref" to 0.2, "lab" to -0.25, "grn" to -0.4, "ld" to 0.05))
)

val UK_BLOCS_BY_ID: Map<String, UkBlocDef> = UK_BLOCS.associateBy { it.id }

val UK_BLOC_IDS: List<String> = UK_BLOCS.map { it.id }

val UK_ISSUES: List<UkIssue> = listOf(
    UkIssue(id = "economy", name = "The Economy", baseSalience = 0.85, blurb = "Growth, jobs, the cost of borrowing."),
    UkIssue(id = "nhs", name = "The NHS", baseSalience = 0.8, blurb = "Waiting lists, funding, social care."),
    UkIssue(id = "immigration", name = "Immigration", baseSalience = 0.65, blurb = "Small boats, net migration, asylum."),
    UkIssue(id = "europe", name = "Europe / Brexit", baseSalience = 0.4, blurb = "Membership, the deal, rejoin vs diverge."),
    UkIssue(id = "cost_of_living", name = "Cost of Living", baseSalience = 0.75, blurb = "Inflation, energy bills, wages."),
    UkIssue(id = "crime", name = "Crime & Policing", baseSalience = 0.5, blurb = "Antisocial behaviour, knife crime, courts."),
    UkIssue(id = "housing", name = "Housing", baseSalience = 0.55, blurb = "Building, planning, rents, the ladder."),
    UkIssue(id = "climate", name = "Climate & Energy", baseSalience = 0.45, blurb = "Net zero, bills, green jobs."),
    UkIssue(id = "scottish_independence", name = "Scottish Independence", baseSalience = 0.3, blurb = "Indyref2, devolution, the Union."),
    UkIssue(id = "taxation", name = "Tax", baseSalience = 0.6, blurb = "The burden, who pays, public services."),
    UkIssue(id = "defence", name = "Defence & Foreign Affairs", baseSalience = 0.4, blurb = "Ukraine, NATO, the nuclear deterrent.")
)

val UK_LEADERS: Map<String, Map<String, UkLeader>> = mapOf(
    "1951" to mapOf("con" to UkLeader(partyId = "con", name = "Winston Churchill", charisma = 78.0, energy = 50.0, competence = 78.0, machine = 84.0), "lab" to UkLeader(partyId = "lab", name = "Clement Attlee", charisma = 42.0, energy = 60.0, competence = 86.0, machine = 78.0), "ld" to UkLeader(partyId = "ld", name = "Clement Davies", charisma = 50.0, energy = 50.0, competence = 60.0, machine = 30.0)),
    "1964" to mapOf("lab" to UkLeader(partyId = "lab", name = "Harold Wilson", charisma = 74.0, energy = 76.0, competence = 72.0, machine = 72.0), "con" to UkLeader(partyId = "con", name = "Alec Douglas-Home", charisma = 40.0, energy = 48.0, competence = 60.0, machine = 70.0), "ld" to UkLeader(partyId = "ld", name = "Jo Grimond", charisma = 70.0, energy = 66.0, competence = 64.0, machine = 30.0)),
    "1966" to mapOf("lab" to UkLeader(partyId = "lab", name = "Harold Wilson", charisma = 74.0, energy = 74.0, competence = 74.0, machine = 76.0), "con" to UkLeader(partyId = "con", name = "Edward Heath", charisma = 44.0, energy = 60.0, competence = 70.0, machine = 68.0), "ld" to UkLeader(partyId = "ld", name = "Jo Grimond", charisma = 70.0, energy = 66.0, competence = 64.0, machine = 32.0)),
    "1970" to mapOf("con" to UkLeader(partyId = "con", name = "Edward Heath", charisma = 46.0, energy = 62.0, competence = 72.0, machine = 70.0), "lab" to UkLeader(partyId = "lab", name = "Harold Wilson", charisma = 72.0, energy = 70.0, competence = 74.0, machine = 76.0), "ld" to UkLeader(partyId = "ld", name = "Jeremy Thorpe", charisma = 74.0, energy = 74.0, competence = 58.0, machine = 34.0)),
    "1997" to mapOf("lab" to UkLeader(partyId = "lab", name = "Tony Blair", charisma = 82.0, energy = 80.0, competence = 74.0, machine = 82.0), "con" to UkLeader(partyId = "con", name = "John Major", charisma = 48.0, energy = 58.0, competence = 64.0, machine = 70.0), "ld" to UkLeader(partyId = "ld", name = "Paddy Ashdown", charisma = 66.0, energy = 70.0, competence = 64.0, machine = 50.0), "ref" to UkLeader(partyId = "ref", name = "James Goldsmith", charisma = 54.0, energy = 56.0, competence = 50.0, machine = 40.0), "snp" to UkLeader(partyId = "snp", name = "Alex Salmond", charisma = 72.0, energy = 70.0, competence = 72.0, machine = 52.0), "pc" to UkLeader(partyId = "pc", name = "Dafydd Wigley", charisma = 56.0, energy = 58.0, competence = 62.0, machine = 36.0)),
    "2010" to mapOf("con" to UkLeader(partyId = "con", name = "David Cameron", charisma = 70.0, energy = 70.0, competence = 66.0, machine = 76.0), "lab" to UkLeader(partyId = "lab", name = "Gordon Brown", charisma = 42.0, energy = 60.0, competence = 70.0, machine = 74.0), "ld" to UkLeader(partyId = "ld", name = "Nick Clegg", charisma = 70.0, energy = 72.0, competence = 60.0, machine = 50.0), "ref" to UkLeader(partyId = "ref", name = "Nigel Farage", charisma = 76.0, energy = 72.0, competence = 48.0, machine = 36.0), "grn" to UkLeader(partyId = "grn", name = "Caroline Lucas", charisma = 58.0, energy = 60.0, competence = 62.0, machine = 28.0), "snp" to UkLeader(partyId = "snp", name = "Alex Salmond", charisma = 74.0, energy = 72.0, competence = 74.0, machine = 58.0), "pc" to UkLeader(partyId = "pc", name = "Ieuan Wyn Jones", charisma = 52.0, energy = 56.0, competence = 60.0, machine = 36.0)),
    "2015" to mapOf("con" to UkLeader(partyId = "con", name = "David Cameron", charisma = 70.0, energy = 68.0, competence = 68.0, machine = 78.0), "lab" to UkLeader(partyId = "lab", name = "Ed Miliband", charisma = 48.0, energy = 62.0, competence = 58.0, machine = 70.0), "ld" to UkLeader(partyId = "ld", name = "Nick Clegg", charisma = 64.0, energy = 64.0, competence = 60.0, machine = 54.0), "ref" to UkLeader(partyId = "ref", name = "Nigel Farage", charisma = 78.0, energy = 76.0, competence = 50.0, machine = 42.0), "grn" to UkLeader(partyId = "grn", name = "Natalie Bennett", charisma = 46.0, energy = 56.0, competence = 50.0, machine = 30.0), "snp" to UkLeader(partyId = "snp", name = "Nicola Sturgeon", charisma = 76.0, energy = 74.0, competence = 76.0, machine = 62.0), "pc" to UkLeader(partyId = "pc", name = "Leanne Wood", charisma = 60.0, energy = 60.0, competence = 60.0, machine = 38.0)),
    "2017" to mapOf("con" to UkLeader(partyId = "con", name = "Theresa May", charisma = 44.0, energy = 58.0, competence = 62.0, machine = 76.0), "lab" to UkLeader(partyId = "lab", name = "Jeremy Corbyn", charisma = 64.0, energy = 72.0, competence = 52.0, machine = 70.0), "ld" to UkLeader(partyId = "ld", name = "Tim Farron", charisma = 52.0, energy = 64.0, competence = 56.0, machine = 48.0), "ref" to UkLeader(partyId = "ref", name = "Paul Nuttall", charisma = 40.0, energy = 50.0, competence = 44.0, machine = 30.0), "grn" to UkLeader(partyId = "grn", name = "Caroline Lucas & Jonathan Bartley", charisma = 58.0, energy = 60.0, competence = 60.0, machine = 32.0), "snp" to UkLeader(partyId = "snp", name = "Nicola Sturgeon", charisma = 74.0, energy = 72.0, competence = 76.0, machine = 66.0), "pc" to UkLeader(partyId = "pc", name = "Leanne Wood", charisma = 60.0, energy = 60.0, competence = 60.0, machine = 38.0)),
    "2019" to mapOf("con" to UkLeader(partyId = "con", name = "Boris Johnson", charisma = 78.0, energy = 74.0, competence = 56.0, machine = 78.0), "lab" to UkLeader(partyId = "lab", name = "Jeremy Corbyn", charisma = 60.0, energy = 66.0, competence = 50.0, machine = 72.0), "ld" to UkLeader(partyId = "ld", name = "Jo Swinson", charisma = 56.0, energy = 70.0, competence = 60.0, machine = 52.0), "ref" to UkLeader(partyId = "ref", name = "Nigel Farage", charisma = 80.0, energy = 78.0, competence = 52.0, machine = 46.0), "grn" to UkLeader(partyId = "grn", name = "Sian Berry & Jonathan Bartley", charisma = 52.0, energy = 60.0, competence = 56.0, machine = 32.0), "snp" to UkLeader(partyId = "snp", name = "Nicola Sturgeon", charisma = 74.0, energy = 72.0, competence = 76.0, machine = 64.0), "pc" to UkLeader(partyId = "pc", name = "Adam Price", charisma = 60.0, energy = 62.0, competence = 64.0, machine = 40.0)),
    "2024" to mapOf("lab" to UkLeader(partyId = "lab", name = "Keir Starmer", charisma = 52.0, energy = 64.0, competence = 74.0, machine = 80.0), "con" to UkLeader(partyId = "con", name = "Rishi Sunak", charisma = 50.0, energy = 60.0, competence = 66.0, machine = 70.0), "ld" to UkLeader(partyId = "ld", name = "Ed Davey", charisma = 58.0, energy = 78.0, competence = 60.0, machine = 50.0), "ref" to UkLeader(partyId = "ref", name = "Nigel Farage", charisma = 80.0, energy = 76.0, competence = 52.0, machine = 48.0), "grn" to UkLeader(partyId = "grn", name = "Carla Denyer & Adrian Ramsay", charisma = 56.0, energy = 62.0, competence = 58.0, machine = 36.0), "snp" to UkLeader(partyId = "snp", name = "John Swinney", charisma = 50.0, energy = 56.0, competence = 64.0, machine = 54.0), "pc" to UkLeader(partyId = "pc", name = "Rhun ap Iorwerth", charisma = 58.0, energy = 60.0, competence = 62.0, machine = 40.0)),
    "1974feb" to mapOf("con" to UkLeader(partyId = "con", name = "Edward Heath", charisma = 44.0, energy = 58.0, competence = 70.0, machine = 68.0), "lab" to UkLeader(partyId = "lab", name = "Harold Wilson", charisma = 70.0, energy = 66.0, competence = 72.0, machine = 74.0), "ld" to UkLeader(partyId = "ld", name = "Jeremy Thorpe", charisma = 76.0, energy = 78.0, competence = 58.0, machine = 38.0)),
    "1974oct" to mapOf("lab" to UkLeader(partyId = "lab", name = "Harold Wilson", charisma = 70.0, energy = 64.0, competence = 72.0, machine = 74.0), "con" to UkLeader(partyId = "con", name = "Edward Heath", charisma = 44.0, energy = 56.0, competence = 70.0, machine = 66.0), "ld" to UkLeader(partyId = "ld", name = "Jeremy Thorpe", charisma = 74.0, energy = 74.0, competence = 56.0, machine = 36.0))
)
