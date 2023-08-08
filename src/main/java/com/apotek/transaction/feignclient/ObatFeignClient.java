package com.apotek.transaction.feignclient;

import com.apotek.transaction.model.ObatDTO;
import com.apotek.transaction.model.ObatHistoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(name = "obat")
public interface ObatFeignClient {
    @GetMapping("/obat/list")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CASHIER')")
    List<ObatDTO> getAllObats();

    @GetMapping("/obat/history/all")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CASHIER')")
    List<ObatHistoryDTO> getAllObatsHistory();

    @GetMapping("/obat/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CASHIER')")
    ObatDTO getObatById(@PathVariable Long id);

}