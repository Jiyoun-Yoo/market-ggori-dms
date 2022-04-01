package com.ggori.dms.service.impl;

import com.ggori.dms.dao.DeliveryDao;
import com.ggori.dms.domain.Delivery;
import com.ggori.dms.service.DeliveryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultDeliveryService implements DeliveryService {
  DeliveryDao deliveryDao;

  public DefaultDeliveryService(DeliveryDao deliveryDao) {
    this.deliveryDao = deliveryDao;
  }

  @Override
  public int addDelivery(Delivery delivery) throws Exception {
    return deliveryDao.insertDelivery(delivery);
  }

  @Override
  public List<Delivery> list() throws Exception {
    return deliveryDao.findAllDelivery();
  }

  @Override
  public Delivery getDeliveryByNo(int deliver_no) throws Exception {
    return deliveryDao.findByDeliveryNo(deliver_no);
  }

  @Override
  public Delivery getDelivery() throws Exception {
    return null;
  }

  @Override
  public int delete(int no) throws Exception {
    return 0;
  }

}
