package com.ggori.dms.service.impl;

import com.ggori.dms.domain.Delivery;
import com.ggori.dms.service.DeliveryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultDeliveryService implements DeliveryService {

  @Override
  public List<Delivery> list(String keyword) throws Exception {
    return null;
  }

  @Override
  public Delivery getDelivery() throws Exception {
    return null;
  }

  @Override
  public int delete(int no) throws Exception {
    return 0;
  }

  @Override
  public int addDelivery(Delivery delivery) throws Exception {
    return 0;
  }
}
