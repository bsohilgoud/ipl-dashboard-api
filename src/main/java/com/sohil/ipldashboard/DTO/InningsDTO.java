package com.sohil.ipldashboard.DTO;

import com.sohil.ipldashboard.DAO.BallToBallDetailsDAO;
import com.sohil.ipldashboard.DAO.BattingDetailsDAO;
import com.sohil.ipldashboard.DAO.BowlingDetailsDAO;
import com.sohil.ipldashboard.DAO.FallOfWicketsDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InningsDTO {
    List<BattingDetailsDAO> battingDetails;
    List<BowlingDetailsDAO> bowlingDetails;
    List<FallOfWicketsDAO> fallOfWickets;
    List<BallToBallDetailsDAO> ballToBallDetails;
    String battingTeam;
}
