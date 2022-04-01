package com.ggori.dms.dao;

import com.ggori.dms.domain.Delivery;
import java.util.List;

public interface DeliveryDao {
  int insertDelivery(Delivery delivery) throws Exception;
  List<Delivery> findAllDelivery() throws Exception;
  Delivery findByDeliveryNo(int deliver_no) throws Exception;

}
