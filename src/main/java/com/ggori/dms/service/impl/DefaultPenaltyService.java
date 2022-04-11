package com.ggori.dms.service.impl;

import com.ggori.dms.dao.PenaltyDao;
import com.ggori.dms.domain.Penalty;
import com.ggori.dms.service.PenaltyService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultPenaltyService implements PenaltyService {
  PenaltyDao penaltyDao;

  public DefaultPenaltyService(PenaltyDao penaltyDao) {
    this.penaltyDao = penaltyDao;
  }

  @Override
  public int addPenalty(Penalty penalty) throws Exception {
    return 0;
  }

  @Override
  public int updatePenalty(Penalty penalty) throws Exception {
    return 0;
  }

  @Override
  public int deletePenalty(int no) throws Exception {
    return 0;
  }

  @Override
  public List<Penalty> list() throws Exception {
    return null;
  }

  @Override
  public Penalty getPenaltyByNo(int no) throws Exception {
    return null;
  }
}
