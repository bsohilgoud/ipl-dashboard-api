package com.sohil.ipldashboard.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "match_details")
public class MatchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchDetailsId;

    @Column(name = "id")
    Long id;
    @Column(name = "innings")
    String innings;
    @Column(name = "overs")
    String overs;
    @Column(name = "ballnumber")
    String ballNumber;
    @Column(name = "batter")
    String batter;
    @Column(name = "bowler")
    String bowler;
    @Column(name = "non_striker")
    String nonStriker;
    @Column(name = "extra_type")
    String extraType;
    @Column(name = "batsman_run")
    String batsmanRun;
    @Column(name = "extras_run")
    String extrasRun;
    @Column(name = "total_run")
    String totalRun;
    @Column(name = "non_boundary")
    String nonBoundary;
    @Column(name = "isWicketDelivery")
    String isWicketDelivery;
    @Column(name = "player_out")
    String playerOut;
    @Column(name = "kind")
    String kind;
    @Column(name = "fielders_involved")
    String fieldersInvolved;
    @Column(name = "BattingTeam")
    String BattingTeam;
}
