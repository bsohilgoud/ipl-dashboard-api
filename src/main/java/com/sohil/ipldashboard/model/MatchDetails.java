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
    @Column(name="id")
    private Long matchCountId;

    @Column(name = "match_id")
    Long id;
    @Column(name = "innings")
    int innings;
    @Column(name = "overs")
    Long overs;
    @Column(name = "ball_number")
    int ballNumber;
    @Column(name = "batter")
    String batter;
    @Column(name = "bowler")
    String bowler;
    @Column(name = "non_striker")
    String nonStriker;
    @Column(name = "extra_type")
    String extraType;
    @Column(name = "batsman_run")
    int batsmanRun;
    @Column(name = "extra_runs")
    int extrasRun;
    @Column(name = "total_run")
    Long totalRun;
    @Column(name = "non_boundary")
    String nonBoundary;
    @Column(name = "is_wicket_delivery")
    int isWicketDelivery;
    @Column(name = "player_out")
    String playerOut;
    @Column(name = "kind")
    String kind;
    @Column(name = "fielders_involved")
    String fieldersInvolved;
    @Column(name = "batting_team")
    String BattingTeam;
}
