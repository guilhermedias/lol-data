package br.psc.guilherme.lol.data.output;

import br.psc.guilherme.lol.data.client.dto.matches.Match;
import br.psc.guilherme.lol.data.client.dto.matches.Participant;
import com.opencsv.bean.CsvBindByName;

public class OutputRecord {
    @CsvBindByName(column = "match.id")
    private final String matchId;
    @CsvBindByName(column = "game.duration")
    private final Integer gameDuration;

    @CsvBindByName(column = "summoner.name")
    private final String summonerName;
    @CsvBindByName(column = "champion.name")
    private final String championName;

    @CsvBindByName(column = "team.position")
    private final String teamPosition;
    @CsvBindByName(column = "individual.position")
    private final String individualPosition;
    @CsvBindByName(column = "role")
    private final String role;
    @CsvBindByName(column = "lane")
    private final String lane;

    @CsvBindByName(column = "kills")
    private final Integer kills;
    @CsvBindByName(column = "deaths")
    private final Integer deaths;
    @CsvBindByName(column = "assists")
    private final Integer assists;

    @CsvBindByName(column = "largest.multi.kill")
    private final Integer largestMultiKill;
    @CsvBindByName(column = "double.kills")
    private final Integer doubleKills;
    @CsvBindByName(column = "triple.kills")
    private final Integer tripleKills;
    @CsvBindByName(column = "quadra.kills")
    private final Integer quadraKills;
    @CsvBindByName(column = "penta.kills")
    private final Integer pentaKills;

    @CsvBindByName(column = "killing.sprees")
    private final Integer killingSprees;
    @CsvBindByName(column = "largest.killing.spree")
    private final Integer largestKillingSpree;

    @CsvBindByName(column = "first.blood.kill")
    private final Boolean firstBloodKill;
    @CsvBindByName(column = "first.blood.assist")
    private final Boolean firstBloodAssist;

    @CsvBindByName(column = "first.tower.kill")
    private final Boolean firstTowerKill;
    @CsvBindByName(column = "first.tower.assist")
    private final Boolean firstTowerAssist;

    @CsvBindByName(column = "total.minions.killed")
    private final Integer totalMinionsKilled;
    @CsvBindByName(column = "neutral.minions.killed")
    private final Integer neutralMinionsKilled;

    @CsvBindByName(column = "physical.damage.dealt")
    private final Integer physicalDamageDealt;
    @CsvBindByName(column = "magic.damage.dealt")
    private final Integer magicDamageDealt;
    @CsvBindByName(column = "true.damage.dealt")
    private final Integer trueDamageDealt;
    @CsvBindByName(column = "total.damage.dealt")
    private final Integer totalDamageDealt;

    @CsvBindByName(column = "physical.damage.dealt.to.champions")
    private final Integer physicalDamageDealtToChampions;
    @CsvBindByName(column = "magic.damage.dealt.to.champions")
    private final Integer magicDamageDealtToChampions;
    @CsvBindByName(column = "true.damage.dealt.to.champions")
    private final Integer trueDamageDealtToChampions;
    @CsvBindByName(column = "total.damage.dealt.to.champions")
    private final Integer totalDamageDealtToChampions;

    @CsvBindByName(column = "damage.dealt.to.objectives")
    private final Integer damageDealtToObjectives;
    @CsvBindByName(column = "damage.dealt.to.buildings")
    private final Integer damageDealtToBuildings;
    @CsvBindByName(column = "damage.dealt.to.turrets")
    private final Integer damageDealtToTurrets;

    @CsvBindByName(column = "physical.damage.taken")
    private final Integer physicalDamageTaken;
    @CsvBindByName(column = "magic.damage.taken")
    private final Integer magicDamageTaken;
    @CsvBindByName(column = "true.damage.taken")
    private final Integer trueDamageTaken;
    @CsvBindByName(column = "total.damage.taken")
    private final Integer totalDamageTaken;

    @CsvBindByName(column = "wards.placed")
    private final Integer wardsPlaced;
    @CsvBindByName(column = "wards.killed")
    private final Integer wardsKilled;
    @CsvBindByName(column = "control.wards.bought")
    private final Integer visionWardsBoughtInGame;
    @CsvBindByName(column = "control.wards.placed")
    private final Integer detectorWardsPlaced;
    @CsvBindByName(column = "vision.score")
    private final Integer visionScore;

    @CsvBindByName(column = "gold.earned")
    private final Integer goldEarned;

    @CsvBindByName(column = "win")
    private final Boolean win;

    public OutputRecord(Match match, Participant participant) {
        this.matchId = match.metadata().matchId();
        this.gameDuration = match.info().gameDuration();

        this.summonerName = participant.summonerName();
        this.championName = participant.championName();

        this.teamPosition = participant.teamPosition();
        this.individualPosition = participant.individualPosition();
        this.role = participant.role();
        this.lane = participant.lane();

        this.kills = participant.kills();
        this.deaths = participant.deaths();
        this.assists = participant.assists();

        this.largestMultiKill = participant.largestMultiKill();
        this.doubleKills = participant.doubleKills();
        this.tripleKills = participant.tripleKills();
        this.quadraKills = participant.quadraKills();
        this.pentaKills = participant.pentaKills();

        this.killingSprees = participant.killingSprees();
        this.largestKillingSpree = participant.largestKillingSpree();

        this.firstBloodKill = participant.firstBloodKill();
        this.firstBloodAssist = participant.firstBloodAssist();

        this.firstTowerKill = participant.firstTowerKill();
        this.firstTowerAssist = participant.firstTowerAssist();

        this.totalMinionsKilled = participant.totalMinionsKilled();
        this.neutralMinionsKilled = participant.neutralMinionsKilled();

        this.physicalDamageDealt = participant.physicalDamageDealt();
        this.magicDamageDealt = participant.magicDamageDealt();
        this.trueDamageDealt = participant.trueDamageDealt();
        this.totalDamageDealt = participant.totalDamageDealt();

        this.physicalDamageDealtToChampions = participant.physicalDamageDealtToChampions();
        this.magicDamageDealtToChampions = participant.magicDamageDealtToChampions();
        this.trueDamageDealtToChampions = participant.trueDamageDealtToChampions();
        this.totalDamageDealtToChampions = participant.totalDamageDealtToChampions();

        this.damageDealtToObjectives = participant.damageDealtToObjectives();
        this.damageDealtToBuildings = participant.damageDealtToBuildings();
        this.damageDealtToTurrets = participant.damageDealtToTurrets();

        this.physicalDamageTaken = participant.physicalDamageTaken();
        this.magicDamageTaken = participant.magicDamageTaken();
        this.trueDamageTaken = participant.trueDamageTaken();
        this.totalDamageTaken = participant.totalDamageTaken();

        this.wardsPlaced = participant.wardsPlaced();
        this.wardsKilled = participant.wardsKilled();
        this.visionWardsBoughtInGame = participant.visionWardsBoughtInGame();
        this.detectorWardsPlaced = participant.detectorWardsPlaced();
        this.visionScore = participant.visionScore();

        this.goldEarned = participant.goldEarned();

        this.win = participant.win();
    }
}
