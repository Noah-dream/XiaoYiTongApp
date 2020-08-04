package com.xiaoyitong.app.service;

import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.stereotype.Service;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
@Service
public interface MessageService {
    String sendMessage(Integer type, String code);
}
