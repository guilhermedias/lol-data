package br.psc.guilherme.lol.data.client.dto.matches;

public record Participant(
        String summonerName,
        String championName,

        String teamPosition,
        String individualPosition,
        String role,
        String lane,

        Integer kills,
        Integer deaths,
        Integer assists,

        Integer largestMultiKill,
        Integer doubleKills,
        Integer tripleKills,
        Integer quadraKills,
        Integer pentaKills,

        Integer killingSprees,
        Integer largestKillingSpree,

        Boolean firstBloodKill,
        Boolean firstBloodAssist,

        Boolean firstTowerKill,
        Boolean firstTowerAssist,

        Integer totalMinionsKilled,
        Integer neutralMinionsKilled,

        Integer physicalDamageDealt,
        Integer magicDamageDealt,
        Integer trueDamageDealt,
        Integer totalDamageDealt,

        Integer physicalDamageDealtToChampions,
        Integer magicDamageDealtToChampions,
        Integer trueDamageDealtToChampions,
        Integer totalDamageDealtToChampions,

        Integer damageDealtToObjectives,
        Integer damageDealtToBuildings,
        Integer damageDealtToTurrets,

        Integer physicalDamageTaken,
        Integer magicDamageTaken,
        Integer trueDamageTaken,
        Integer totalDamageTaken,

        Integer wardsPlaced,
        Integer wardsKilled,
        Integer visionWardsBoughtInGame,
        Integer detectorWardsPlaced,
        Integer visionScore,

        Integer goldEarned,

        Boolean win) {
}
