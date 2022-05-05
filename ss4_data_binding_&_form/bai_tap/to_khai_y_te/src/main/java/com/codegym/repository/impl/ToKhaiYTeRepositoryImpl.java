package com.codegym.repository.impl;

import com.codegym.model.ToKhaiYTe;
import com.codegym.repository.IToKhaiYTeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ToKhaiYTeRepositoryImpl implements IToKhaiYTeRepository {
    private ToKhaiYTe toKhaiYTe = new ToKhaiYTe();

    @Override
    public ToKhaiYTe getToKhai() {
        return toKhaiYTe;
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        this.toKhaiYTe = toKhaiYTe;
    }
}
