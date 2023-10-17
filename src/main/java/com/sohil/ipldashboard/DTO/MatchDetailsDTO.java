package com.sohil.ipldashboard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatchDetailsDTO {
    InningsDTO firstInnings;
    InningsDTO secondInnings;
    Long matchId;
}
