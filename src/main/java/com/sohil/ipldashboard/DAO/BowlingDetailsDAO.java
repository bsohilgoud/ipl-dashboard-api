package com.sohil.ipldashboard.DAO;

import java.util.List;
import org.hibernate.annotations.Type;


public interface BowlingDetailsDAO {
    String getBowlerName();
    Integer getNoOfWickets();
    Integer getNoOfOvers();
    Integer getTotalRuns();
    Float getRunRate();
    List<String> getWicketsTaken();
    Integer getNoOfFours();
    Integer getNoOfSixes();
    Integer getExtraRuns();
}
