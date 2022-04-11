package com.ggori.dms.service;

import com.ggori.dms.domain.Penalty;
import java.util.List;

public interface PenaltyService {
  int addPenalty(Penalty penalty) throws Exception;
  int updatePenalty(Penalty penalty) throws Exception;
  int deletePenalty(int no) throws Exception;
  List<Penalty> list() throws Exception;
  Penalty getPenaltyByNo(int no) throws Exception;
}
