package br.psc.guilherme.lol.data.output;

import br.psc.guilherme.lol.data.client.dto.matches.Match;
import br.psc.guilherme.lol.data.client.dto.matches.Participant;

@SuppressWarnings("FieldCanBeLocal")
public class OutputRecord {
    private final String matchId;
    private final Integer gameDuration;

    private final String summonerName;
    private final String championName;

    private final String teamPosition;
    private final String individualPosition;
    private final String role;
    private final String lane;

    private final Integer kills;
    private final Integer deaths;
    private final Integer assists;

    private final Integer largestMultiKill;
    private final Integer doubleKills;
    private final Integer tripleKills;
    private final Integer quadraKills;
    private final Integer pentaKills;

    private final Integer killingSprees;
    private final Integer largestKillingSpree;

    private final Boolean firstBloodKill;
    private final Boolean firstBloodAssist;

    private final Boolean firstTowerKill;
    private final Boolean firstTowerAssist;

    private final Integer totalMinionsKilled;
    private final Integer neutralMinionsKilled;

    private final Integer physicalDamageDealt;
    private final Integer magicDamageDealt;
    private final Integer trueDamageDealt;
    private final Integer totalDamageDealt;

    private final Integer physicalDamageDealtToChampions;
    private final Integer magicDamageDealtToChampions;
    private final Integer trueDamageDealtToChampions;
    private final Integer totalDamageDealtToChampions;

    private final Integer damageDealtToObjectives;
    private final Integer damageDealtToBuildings;
    private final Integer damageDealtToTurrets;

    private final Integer physicalDamageTaken;
    private final Integer magicDamageTaken;
    private final Integer trueDamageTaken;
    private final Integer totalDamageTaken;

    private final Integer wardsPlaced;
    private final Integer wardsKilled;
    private final Integer visionWardsBoughtInGame;
    private final Integer detectorWardsPlaced;
    private final Integer visionScore;

    private final Integer goldEarned;

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
