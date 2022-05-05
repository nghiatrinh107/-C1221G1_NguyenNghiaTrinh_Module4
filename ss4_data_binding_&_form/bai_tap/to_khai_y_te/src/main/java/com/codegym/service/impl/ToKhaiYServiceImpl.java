package com.codegym.service.impl;

import com.codegym.model.ToKhaiYTe;
import com.codegym.repository.IToKhaiYTeRepository;
import com.codegym.service.IToKhaiYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToKhaiYServiceImpl  implements IToKhaiYTeService {
    @Autowired
    private IToKhaiYTeRepository iToKhaiYTeRepository;
    @Override
    public ToKhaiYTe getToKhai() {
        return iToKhaiYTeRepository.getToKhai();
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        iToKhaiYTeRepository.save(toKhaiYTe);
    }

}
