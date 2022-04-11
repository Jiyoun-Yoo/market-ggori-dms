package com.ggori.dms.service;

import com.ggori.dms.domain.VOC;
import java.util.List;

public interface VOCService {
  int addVOC(VOC voc) throws Exception;
  int updateVOC(VOC voc) throws Exception;
  int deleteVOC(int no) throws Exception;
  List<VOC> list() throws Exception;
  VOC getVOCByNo(int no) throws Exception;
}
