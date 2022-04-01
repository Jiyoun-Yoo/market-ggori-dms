package com.ggori.dms.service;

import com.ggori.dms.domain.Delivery;
import java.util.List;

public interface DeliveryService {
  int addDelivery(Delivery delivery) throws Exception;
  List<Delivery> list() throws Exception;
  Delivery getDeliveryByNo(int deliver_no) throws Exception;
  Delivery getDelivery() throws Exception;
  int delete(int no) throws Exception;
}
