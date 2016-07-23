package com.sinoway.sinowayCrawer.service;
public interface JXLPostService {
	 public String sendCreditRequest(
             String name,
             String cell_phone_num,
             String id_card_num,
             String account,
             String password,
             String captcha);
}
