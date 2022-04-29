package com.codegym.service.imp;

import com.codegym.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public Double convert(Double a) {
      return   a*23000;

    }
}
