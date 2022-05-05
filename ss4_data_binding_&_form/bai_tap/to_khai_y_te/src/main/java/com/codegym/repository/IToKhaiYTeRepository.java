package com.codegym.repository;

import com.codegym.model.ToKhaiYTe;

public interface IToKhaiYTeRepository {
    ToKhaiYTe getToKhai();
    void save(ToKhaiYTe toKhaiYTe);
}
