package com.duongthuy.project.service;

import com.duongthuy.project.repository.TransactionDetailRepository;
import com.duongthuy.project.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    private final TransactionDetailRepository transactionDetailRepository;

    private final ModelMapper modelMapper;


}
