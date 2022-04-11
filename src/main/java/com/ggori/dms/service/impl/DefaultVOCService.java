package com.ggori.dms.service.impl;

import com.ggori.dms.dao.VOCDao;
import com.ggori.dms.domain.VOC;
import com.ggori.dms.service.PenaltyService;
import com.ggori.dms.service.VOCService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultVOCService implements VOCService {
  VOCDao vocDao;

  public DefaultVOCService(VOCDao vocDao) {
    this.vocDao = vocDao;
  }

  @Override
  public int addVOC(VOC voc) throws Exception {
    return 0;
  }

  @Override
  public int updateVOC(VOC voc) throws Exception {
    return 0;
  }

  @Override
  public int deleteVOC(int no) throws Exception {
    return 0;
  }

  @Override
  public List<VOC> list() throws Exception {
    return null;
  }

  @Override
  public VOC getVOCByNo(int no) throws Exception {
    return null;
  }
}
