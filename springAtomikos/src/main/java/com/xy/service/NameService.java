package com.xy.service;

import com.xy.dao.NameQaMapper;
import com.xy.daodev.NameDevMapper;
import com.xy.model.NameDev;
import com.xy.model.NameQa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 11
 */
@Service
public class NameService {
    @Autowired
    NameQaMapper nameQaMapper;
    @Autowired
    NameDevMapper nameDevMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addQaAndDev(boolean hasException) throws Exception {
        NameQa nameQa = new NameQa();
        nameQa.setNameQa("qa");
        nameQaMapper.insert(nameQa);

        NameDev nameDev = new NameDev();
        nameDev.setNameDev("dev");
        nameDevMapper.insert(nameDev);

        if(hasException) {
            throw new Exception();
        }
    }


}
