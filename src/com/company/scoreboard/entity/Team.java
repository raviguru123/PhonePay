package com.company.scoreboard.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Setter
@Getter
public class Team {
    private String name;
    private String id;
    private Integer noOffPlayers;
    private Integer noOfOvers;
    private List<Player> playerList;
    public Map<String, Player> playerByName = new HashMap<>();
}
