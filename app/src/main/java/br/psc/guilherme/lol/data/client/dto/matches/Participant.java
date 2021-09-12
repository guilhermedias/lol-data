package br.psc.guilherme.lol.data.client.dto.matches;

public record Participant(
        // General info
        String summonerName,
        String championName,

        // Position
        String teamPosition,
        String individualPosition,
        String role,
        String lane,

        // KDA
        Integer kills,
        Integer deaths,
        Integer assists,

        // Multi kill
        Integer largestMultiKill,
        Integer doubleKills,
        Integer tripleKills,
        Integer quadraKills,
        Integer pentaKills,

        // Killing spree
        Integer killingSprees,
        Integer largestKillingSpree,

        // First blood
        Boolean firstBloodKill,
        Boolean firstBloodAssist,

        // First brick
        Boolean firstTowerKill,
        Boolean firstTowerAssist,

        // Minions
        Integer totalMinionsKilled,
        Integer neutralMinionsKilled,

        // Damage dealt
        Integer physicalDamageDealt,
        Integer magicDamageDealt,
        Integer trueDamageDealt,
        Integer totalDamageDealt,

        // Damage dealt to champions
        Integer physicalDamageDealtToChampions,
        Integer magicDamageDealtToChampions,
        Integer trueDamageDealtToChampions,
        Integer totalDamageDealtToChampions,

        // Other types of damage
        Integer damageDealtToObjectives,
        Integer damageDealtToBuildings,
        Integer damageDealtToTurrets,

        // Damage taken
        Integer physicalDamageTaken,
        Integer magicDamageTaken,
        Integer trueDamageTaken,
        Integer totalDamageTaken,

        // Vision
        Integer wardsPlaced,
        Integer wardsKilled,
        Integer visionWardsBoughtInGame,
        Integer detectorWardsPlaced,
        Integer visionScore,

        // Gold
        Integer goldEarned,

        // Win or lose?
        Boolean win) {
}
